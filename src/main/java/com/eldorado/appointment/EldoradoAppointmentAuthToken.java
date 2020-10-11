package com.eldorado.appointment;

import com.eldorado.appointment.payload.user.UserResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class EldoradoAppointmentAuthToken extends UsernamePasswordAuthenticationToken {

    private static final long serialVersionUID = 1L;

    public EldoradoAppointmentAuthToken(UserResponse principal, Object credentials,
                                        Collection<? extends GrantedAuthority> authorities) {

        super(principal, credentials, authorities);
    }

    public UserResponse getUser() {
        return (UserResponse) getPrincipal();
    }
}
