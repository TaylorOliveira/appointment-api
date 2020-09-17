package com.eldorado.appointment;

import com.eldorado.appointment.dto.UsuarioDTO;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class EldoradoAppointmentAuthToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    public EldoradoAppointmentAuthToken(UsuarioDTO principal, Object credentials,
                                        Collection<? extends GrantedAuthority> authorities) {

        super(principal, credentials, authorities);
    }

    public UsuarioDTO getUsuario() {
        return (UsuarioDTO) getPrincipal();
    }
}
