package com.ba.Builder;


import com.ba.Entities.Users;

public class UsersBuilder {

    private long user_id;

    private String username;

    private String password;

    private boolean enabled;

    public UsersBuilder enabled(boolean enabled) {
        this.enabled = enabled;
        return this;
    }

    public UsersBuilder password(String password) {
        this.password = password;
        return this;
    }



    public UsersBuilder username(String username) {
        this.username = username;
        return this;
    }

    public Users build(){

        Users user=new Users();

        user.setUsername(this.username);
        user.setPassword(this.password);
        user.setEnabled(this.enabled);


        return user;

    }





}
