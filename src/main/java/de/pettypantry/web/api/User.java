package de.pettypantry.web.api;

public class User {
    private int userid;
    private String firstName;
    private String lastName;

    public User(int userid, String firstName, String lastName) {
        this.userid = userid;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getUserid() {
        return userid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
