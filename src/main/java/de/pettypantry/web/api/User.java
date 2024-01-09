package de.pettypantry.web.api;

public class User {
    private int userID;
    private String userName;
    private String password;

    public User(int userid, String userName, String password) {
        this.userID = userid;
        this.userName = userName;
        this.password = password;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
