package com.ba.DTO;


import com.ba.Entities.Role;

import java.util.HashSet;
import java.util.Set;

public class UsersDTO {

    private Long user_id;

    private String username;
    private String password;
    private boolean enabled;

    private Set<Role> roles=new HashSet<>();

    private long [] roles_id;



    public UsersDTO() {
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public long[] getRoles_id() {
        return roles_id;
    }

    public void setRoles_id(long[] roles_id) {
        this.roles_id = roles_id;
    }
}
