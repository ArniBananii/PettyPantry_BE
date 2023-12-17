package de.pettypantry.web.api;

public class Ingredient {

    private int ingredientID;
    private String ingredientName;
    private int validNoOfDays;
    private String imageURL;

    public Ingredient(int ingredientID, String ingredientName, int validNoOfDays, String imageURL) {
        this.ingredientID = ingredientID;
        this.ingredientName = ingredientName;
        this.validNoOfDays = validNoOfDays;
        this.imageURL = imageURL;
    }

    public int getIngredientID() {
        return ingredientID;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getValidNoOfDays() {
        return validNoOfDays;
    }

    public void setValidNoOfDays(int validNoOfDays) {
        this.validNoOfDays = validNoOfDays;
    }
}
