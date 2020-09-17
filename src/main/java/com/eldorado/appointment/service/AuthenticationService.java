package com.eldorado.appointment.service;

import com.eldorado.appointment.AutorizadorUsuario;
import com.eldorado.appointment.dto.UsuarioDTO;
import com.eldorado.appointment.payload.doctor.DoctorRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;

@Component
public class AuthenticationService {

    private final DoctorService doctorService;

    @Autowired
    public AuthenticationService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    public UsuarioDTO authenticate(final String login, final String password) {
        try {
            if(login.equals("taylor.oliveira") && password.equals("123456")){
                ArrayList<String> perfis = new ArrayList<>();
                perfis.add("USER");

                AutorizadorUsuario autorizadorUsuario = new AutorizadorUsuario("TAYLOR OLIVEIRA",
                        "taylor.oliveira@gmail.com", perfis);
                return autorizadorUsuario.toUsuarioDTO(login);
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