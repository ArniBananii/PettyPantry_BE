package de.pettypantry.entity;

import jakarta.persistence.*;

import java.util.Set;

//Could have generated value for personId but will do in controller for now!
@Table(name = "users")
@Entity(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "firstname", nullable = false)
    private String firstName;

    @Column(name = "lastname", nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PANTRY",
    joinColumns = {
            @JoinColumn(name = "user_id", referencedColumnName = "userId")
    },
    inverseJoinColumns = {
            @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredientId")
    })
    private Set<IngredientEntity> ingredients;

    public UserEntity(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    protected UserEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
