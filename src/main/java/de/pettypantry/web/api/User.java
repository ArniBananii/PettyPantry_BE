package de.pettypantry.web.api;

public class User {
    private int userID;
    private String userName;

    public User(int userid, String userName) {
        this.userID = userid;
        this.userName = userName;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }
}
