package com.eldorado.appointment;

import java.util.ArrayList;
import java.util.List;
import com.eldorado.appointment.payload.user.UserResponse;

public class AuthorizerUser {

    private String name;
    private String email;
    private List<String> profiles;

    public AuthorizerUser(String name, String email, List<String> profiles) {
        this.name = name;
        this.email = email;
        this.profiles = profiles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getProfiles() {
        if (this.profiles == null) {
            this.profiles = new ArrayList<>(0);
        }
        return this.profiles;
    }

    public void setProfiles(List<String> profiles) {
        this.profiles = profiles;
    }

    public UserResponse toUserResponse(final String login) {
        return UserResponse.getBuilder().login(login).name(name).email(email).profiles(profiles)
                .build();
    }
}
