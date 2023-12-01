package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PantryModel {

    @JsonProperty(namespace = "userid")
    private int userid;

    public PantryModel(int userid) {
        this.userid = userid;
    }

    public PantryModel() {
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
