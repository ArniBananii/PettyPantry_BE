package de.pettypantry.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "PANTRY")
@Table(name = "PANTRY")
public class PantryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pantryId;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userId", nullable = false)
    private UserEntity ownerUser;

    @OneToMany(mappedBy = "pantry")
    private Set<UniqueIngredientEntity> ingredients;

    public PantryEntity(UserEntity ownerUser) {
        this.ownerUser = ownerUser;
    }

    public int getPantryId() {
        return pantryId;
    }

    public UserEntity getOwnerUser() {
        return ownerUser;
    }

    public Set<UniqueIngredientEntity> getIngredients() {
        return ingredients;
    }

    public void setIngredients(Set<UniqueIngredientEntity> ingredients) {
        this.ingredients = ingredients;
    }
}
