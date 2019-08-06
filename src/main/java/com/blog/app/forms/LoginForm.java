package com.blog.app.forms;

import com.sun.istack.internal.NotNull;

import javax.validation.constraints.Size;

public class LoginForm {

    @Size(min = 2, max = 10,message = " Username must be Maximum 10 charcters")
    private String username;

    @SuppressWarnings("restriction")
	@Size(min = 3,max=10, message="Password must be max 10 charcters")
    @NotNull
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
