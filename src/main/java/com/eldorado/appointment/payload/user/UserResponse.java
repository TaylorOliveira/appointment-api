package com.eldorado.appointment.payload.user;

import org.hibernate.engine.internal.Collections;

import java.util.List;

public class UserResponse {

    public final String login;
    public final String name;
    public final String email;
    public final List<String> profiles;

    public UserResponse(String login, String name, String email, List<String> profiles) {
        this.login = login;
        this.name = name;
        this.email = email;
        this.profiles = profiles == null ? Collections.emptyList() : Collections.unmodifiableList(profiles);
    }

    public static UserResponseBuilder getBuilder() {
        return new UserResponseBuilder();
    }

    public static class UserResponseBuilder {

        public final String login;
        public final String name;
        public final String email;
        public final List<String> profiles;

        public UserResponseBuilder login(String login) {
            this.login = login;
            return this;
        }

        public UserResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserResponseBuilder profiles(List<String> profiles) {
            this.profiles = profiles;
            return this;
        }

        public UserResponse build() {
            return new UserResponse(login, name, email, profiles);
        }
    }
}
