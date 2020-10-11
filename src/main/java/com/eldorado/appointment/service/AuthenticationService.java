package com.eldorado.appointment.service;

import com.eldorado.appointment.AuthorizerUser;
import com.eldorado.appointment.payload.user.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

@Component
public class AuthenticationService {

    @Autowired
    public AuthenticationService() { }

    public UserResponse authenticate(final String login, final String password) {
        try {
            if(login.equals("taylor.oliveira") && password.equals("123456")){
                ArrayList<String> perfis = new ArrayList<>();
                perfis.add("USER");
                AuthorizerUser authorizerUser = new AuthorizerUser("TAYLOR OLIVEIRA",
                        "taylor.oliveira@gmail.com", perfis);
                return authorizerUser.toUserResponse(login);
            }
            return null;
        } catch (RuntimeException ex) {
            if (ex instanceof HttpClientErrorException) {
                final HttpClientErrorException httpError = (HttpClientErrorException) ex;
                if (httpError.getStatusCode().is4xxClientError()) {
                    return null;
                }
            }
            throw new RuntimeException("Erro ao realizar autenticacao", ex);
        }
    }
}