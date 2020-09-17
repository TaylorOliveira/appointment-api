package com.eldorado.appointment;

import java.util.ArrayList;
import java.util.List;
import com.eldorado.appointment.dto.UsuarioDTO;

public class AutorizadorUsuario {

    private String nome;
    private String email;
    private List<String> perfis;

    public AutorizadorUsuario(String nome, String email, List<String> perfis) {
        this.nome = nome;
        this.email = email;
        this.perfis = perfis;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getPerfis() {
        if (this.perfis == null) {
            this.perfis = new ArrayList<>(0);
        }
        return this.perfis;
    }

    public void setPerfis(List<String> perfis) {
        this.perfis = perfis;
    }

    public UsuarioDTO toUsuarioDTO(final String login) {
        return UsuarioDTO.getBuilder().login(login).nome(nome).email(email).perfis(perfis)
                .construir();
    }
}
