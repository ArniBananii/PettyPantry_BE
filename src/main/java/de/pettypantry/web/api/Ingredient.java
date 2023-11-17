package de.pettypantry.web.api;

public class Ingredient {

    private int ingredientId;
    private String ingredientName;
    private int validNoOfDays;

    public Ingredient(int ingredientId, String ingredientName, int validNoOfDays) {
        this.ingredientId = ingredientId;
        this.ingredientName = ingredientName;
        this.validNoOfDays = validNoOfDays;
    }

    public int getIngredientId() {
        return ingredientId;
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
