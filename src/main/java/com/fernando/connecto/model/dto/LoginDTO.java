package com.fernando.connecto.model.dto;

import com.fernando.connecto.model.UserLogin;

public class LoginDTO {
    private long id;
    private String email;
    private String token;

    public LoginDTO(UserLogin user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.token = user.getToken();
    }

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getToken() {
        return token;
    }
}
