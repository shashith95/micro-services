package com.employer.model.entity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "EMPLOYER", schema = "dm_management", catalog = "postgres")
public class Employer {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "ID", nullable = false)
    private Integer id;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "ADDRESS_LINE_ONE")
    private String addressLineOne;

    @Column(name = "ADDRESS_LINE_TWO")
    private String addressLineTwo;

    public Employer() {
    }

    public Employer(Integer id, String firstName, String lastName, String addressLineOne, String addressLineTwo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.addressLineOne = addressLineOne;
        this.addressLineTwo = addressLineTwo;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddressLineOne() {
        return addressLineOne;
    }

    public String getAddressLineTwo() {
        return addressLineTwo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employer that = (Employer) o;
        return Objects.equals(id, that.id) && Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) && Objects.equals(addressLineOne, that.addressLineOne) &&
                Objects.equals(addressLineTwo, that.addressLineTwo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, addressLineOne, addressLineTwo);
    }
}
