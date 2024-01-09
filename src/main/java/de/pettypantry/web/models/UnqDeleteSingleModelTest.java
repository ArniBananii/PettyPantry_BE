package de.pettypantry.web.models;
import com.fasterxml.jackson.annotation.JsonProperty;
public class UnqDeleteSingleModelTest {
    @JsonProperty("UnqID")
    private int unqIngID;

    public UnqDeleteSingleModelTest(int unqIngID) {
        this.unqIngID = unqIngID;
    }

    public UnqDeleteSingleModelTest() {
    }

    public int getUnqIngID() {
        return unqIngID;
    }
}

