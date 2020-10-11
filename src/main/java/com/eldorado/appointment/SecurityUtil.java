package com.eldorado.appointment;

import com.eldorado.appointment.payload.user.UserResponse;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

public class SecurityUtil {
    public static UserResponse getUsuario(final HttpServletRequest request) {
        final EldoradoAppointmentAuthToken authToken = getToken(request);
        return authToken == null ? null : authToken.getUser();
    }

    private static EldoradoAppointmentAuthToken getToken(final HttpServletRequest request) {
        final Principal principal = request.getUserPrincipal();
        if (!(principal instanceof EldoradoAppointmentAuthToken)) {
            return null;
        }
        return (EldoradoAppointmentAuthToken) principal;
    }

}
