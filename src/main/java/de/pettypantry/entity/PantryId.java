package de.pettypantry.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;


@Embeddable
public class PantryId implements Serializable {
    @Column(name = "user_id")
    private int userId;

    @Column(name = "ingredient_id")
    private int ingredientId;

    @Column(name = "put_date")
    private LocalDate putDate;

    @Override
    public int hashCode() {
        return Objects.hash(userId, ingredientId, putDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if(obj == null || getClass() != obj.getClass()) return false;
        PantryId pantryIdObject = (PantryId) obj;
        return Objects.equals(userId, pantryIdObject.userId) &&
                Objects.equals(ingredientId, pantryIdObject.ingredientId) &&
                Objects.equals(putDate, pantryIdObject.putDate);
    }

    public PantryId(int userId, int ingredientId, LocalDate putDate) {
        this.userId = userId;
        this.ingredientId = ingredientId;
        this.putDate = putDate;
    }

    protected PantryId() {
    }

    public int getUserId() {
        return userId;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public LocalDate getPutDate() {
        return putDate;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public void setPutDate(LocalDate putDate) {
        this.putDate = putDate;
    }
}
