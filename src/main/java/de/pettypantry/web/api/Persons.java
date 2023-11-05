package de.pettypantry.web.api;

public class Persons {
    private int personId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;


    public Persons(int personId, String firstName, String lastName, String address, String city) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPersonId() {
        return personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }
}
