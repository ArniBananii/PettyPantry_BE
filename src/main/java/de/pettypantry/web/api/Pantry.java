package de.pettypantry.web.api;

public class Pantry {

    private int pantryid;

    private int userid;

    public Pantry(int pantryid, int userid) {
        this.pantryid = pantryid;
        this.userid = userid;
    }

    public int getPantryid() {
        return pantryid;
    }

    public void setPantryid(int pantryid) {
        this.pantryid = pantryid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
