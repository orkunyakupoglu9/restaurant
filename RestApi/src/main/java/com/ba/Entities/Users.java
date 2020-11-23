package com.ba.Entities;


import javax.persistence.*;

@Entity
public class Users {



    @Id
    @Column(name="username",nullable = false)
    private String username;


    private String password;
    private boolean enabled;



    public Users() {
    }


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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
