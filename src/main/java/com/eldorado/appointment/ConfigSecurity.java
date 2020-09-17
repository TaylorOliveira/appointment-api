package com.eldorado.appointment;

import com.eldorado.appointment.dto.UsuarioDTO;
import com.eldorado.appointment.service.AuthenticationService;
import com.eldorado.appointment.service.ConfigService;
import com.eldorado.appointment.util.ConfigKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(jsr250Enabled = true)
public class ConfigSecurity extends WebSecurityConfigurerAdapter  {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationService authService;

    @Autowired
    private ConfigService configService;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        final EldoradoAppointmentAuthenticationProvider provider = new EldoradoAppointmentAuthenticationProvider();
        auth.authenticationProvider(provider);
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        final AuthenticationFailureHandler falhaAutenticacao = new RestAuthFailureHandler();
        final AuthenticationSuccessHandler sucessoAutenticacao = new RestAuthSuccessHandler();
        final LogoutSuccessHandler sucessoLogout = new HttpStatusReturningLogoutSuccessHandler(HttpStatus.OK);
        final AuthenticationEntryPoint entryPoint = new RestAuthEntryPoint();

        http
                .csrf().disable()

                .cors().and()

                .exceptionHandling().authenticationEntryPoint(entryPoint).and()

                .authorizeRequests().antMatchers("/login", "/logout").permitAll().anyRequest().authenticated().and()

                .formLogin().usernameParameter("username").passwordParameter("password")
                .loginProcessingUrl("/login").successHandler(sucessoAutenticacao).failureHandler(falhaAutenticacao)
                .and()

                .logout().logoutUrl("/logout").logoutSuccessHandler(sucessoLogout).invalidateHttpSession(true);
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {

                final String[] origensPermitidas = configService.getString(ConfigKey.CORS_ALLOWED_ORIGINS).split(",");

                LoggerFactory.getLogger(getClass()).debug("CORS allowed-origins => {}",
                        Arrays.toString(origensPermitidas));

                registry.addMapping("/**").allowedOrigins(origensPermitidas).allowCredentials(true);
            }
        };
    }

    private static class RestAuthEntryPoint implements AuthenticationEntryPoint {

        @Override
        public void commence(HttpServletRequest request, HttpServletResponse response,
                             AuthenticationException authException) throws IOException {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private static class RestAuthFailureHandler implements AuthenticationFailureHandler {

        @Override
        public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                            AuthenticationException exception) throws IOException, ServletException {

            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

    private static class RestAuthSuccessHandler implements AuthenticationSuccessHandler {

        @Override
        public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                            Authentication authentication) throws ServletException, IOException {

            response.setStatus(HttpServletResponse.SC_OK);
        }
    }

    private class EldoradoAppointmentAuthenticationProvider implements AuthenticationProvider {

        @Override
        public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
            final String login = authentication.getName();
            final String senha = toString(authentication.getCredentials());

            final UsuarioDTO user = authService.authenticate(login, senha);

            if (user == null) {
                logger.debug("Login e/ou senha invalidos => login: {}", login);
                return null;
            }

            final List<GrantedAuthority> authorities = user.perfis.stream()
                    .map(p -> new SimpleGrantedAuthority("ROLE_" + p)).collect(Collectors.toList());

            return new EldoradoAppointmentAuthToken(user, null, authorities);
        }

        private String toString(Object obj) {
            return obj == null ? "" : obj.toString();
        }

        @Override
        public boolean supports(Class<?> authentication) {
            return authentication.isAssignableFrom(UsernamePasswordAuthenticationToken.class);
        }

    }
}
