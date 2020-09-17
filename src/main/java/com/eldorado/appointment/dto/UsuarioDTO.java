package com.eldorado.appointment.dto;

import java.util.Collections;
import java.util.List;

public class UsuarioDTO {

    public final String login;
    public final String nome;
    public final String email;
    public final List<String> perfis;

    private UsuarioDTO(String login, String nome, String email, List<String> perfis) {
        this.login = login;
        this.nome = nome;
        this.email = email;
        this.perfis = perfis == null ? Collections.emptyList() : Collections.unmodifiableList(perfis);
    }

    public static UsuarioDTOBuilder getBuilder() {
        return new UsuarioDTOBuilder();
    }

    public static class UsuarioDTOBuilder {

        private String login;
        private String nome;
        private String email;
        private List<String> perfis;

        public UsuarioDTOBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UsuarioDTOBuilder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public UsuarioDTOBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioDTOBuilder perfis(List<String> perfis) {
            this.perfis = perfis;
            return this;
        }

        public UsuarioDTO construir() {
            return new UsuarioDTO(login, nome, email, perfis);
        }

    }

}