package de.pettypantry.entity;

import de.pettypantry.web.api.User;
import jakarta.persistence.*;

import java.time.LocalDate;
import jakarta.persistence.*;

import java.util.Set;

@Entity(name = "PANTRY")
@Table(name = "PANTRY")
public class Pantry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pantryId;

    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userId", nullable = false)
    private UserEntity ownerUser;

    @OneToMany(mappedBy = "pantry")
    private Set<UniqueIngredientEntity> ingredients;
}
