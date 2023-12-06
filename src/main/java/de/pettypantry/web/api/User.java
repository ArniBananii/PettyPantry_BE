package de.pettypantry.web.api;

public class User {
    private int userid;
    private String userName;
    private String password;

    public User(int userid, String userName, String password) {
        this.userid = userid;
        this.userName = userName;
        this.password = password;
    }

    public int getUserid() {
        return userid;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
