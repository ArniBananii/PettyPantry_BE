package de.pettypantry.web.api;

public class Pantry {

    private int pantryID;

    private int userID;

    public Pantry(int pantryID, int userID) {
        this.pantryID = pantryID;
        this.userID = userID;
    }

    public int getPantryID() {
        return pantryID;
    }

    public int getUserID() {
        return userID;
    }
}
