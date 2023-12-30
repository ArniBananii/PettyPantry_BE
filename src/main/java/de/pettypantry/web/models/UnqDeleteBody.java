package de.pettypantry.web.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.lang.reflect.Array;

public class UnqDeleteBody {

    @JsonProperty("UnqIDs")
    private int[] unqIngIDs;

    public UnqDeleteBody(int[] unqIngIDs) {
        this.unqIngIDs = unqIngIDs;
    }

    public UnqDeleteBody() {
    }

    public int[] getUnqIngIDs() {
        return unqIngIDs;
    }
}
