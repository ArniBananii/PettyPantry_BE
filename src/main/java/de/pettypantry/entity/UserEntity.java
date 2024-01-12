package de.pettypantry.entity;

import jakarta.persistence.*;

//Could have generated value for personId but will do in controller for now!
@Table(name = "PANTRYUSER")
@Entity(name = "USER")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(name = "username", nullable = false)
    private String userName;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "ownerUser")
    private PantryEntity userPantry;

    public UserEntity(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    protected UserEntity() {
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String firstName) {
        this.userName = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setLastName(String lastName) {
        this.password = lastName;
    }

    public PantryEntity getUserPantry() {
        return userPantry;
    }
}
