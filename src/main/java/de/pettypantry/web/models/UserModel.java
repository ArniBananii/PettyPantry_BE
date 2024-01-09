package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserModel {

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("password")
    private String password;

    public UserModel() {
    }

    public UserModel(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
