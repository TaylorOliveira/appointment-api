package com.eldorado.appointment;

import com.eldorado.appointment.dto.UsuarioDTO;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public class SecurityUtil {
    public static UsuarioDTO getUsuario(final HttpServletRequest request) {
        final EldoradoAppointmentAuthToken authToken = getToken(request);
        return authToken == null ? null : authToken.getUsuario();
    }

    private static EldoradoAppointmentAuthToken getToken(final HttpServletRequest request) {
        final Principal principal = request.getUserPrincipal();
        if (!(principal instanceof EldoradoAppointmentAuthToken)) {
            return null;
        }
        return (EldoradoAppointmentAuthToken) principal;
    }

}
