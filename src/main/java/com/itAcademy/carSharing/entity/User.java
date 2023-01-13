package com.itAcademy.carSharing.entity;

import java.util.Objects;
import java.util.StringJoiner;

public class User extends AbstractEntity {
    private String name;
    private String surName;
    private String dateOfExpirity;
    private String identificationNumber;
    private String mail;
    private String pass;
    private int role;

    public enum UsersRole {
        ADMIN,
        CUSTOMER
    }

    public User(String name, String surName, String dateOfExpirity, String identificationNumber, String mail, String pass) {
        this.name = name;
        this.surName = surName;
        this.dateOfExpirity = dateOfExpirity;
        this.identificationNumber = identificationNumber;
        this.mail = mail;
        this.pass = pass;
        this.role = UsersRole.CUSTOMER.ordinal();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public String getIdentificationNumber() {
        return identificationNumber;
    }

    public String getMail() {
        return mail;
    }

    public String getPass() {
        return pass;
    }

    public int getRole() {
        return role;
    }

    public String getDateOfExpirity() {
        return dateOfExpirity;
    }

    public void setDateOfExpirity(String dateOfExpirity) {
        this.dateOfExpirity = dateOfExpirity;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return role == user.role && name.equals(user.name) && surName.equals(user.surName) && dateOfExpirity.equals(user.dateOfExpirity) && identificationNumber.equals(user.identificationNumber) && mail.equals(user.mail) && pass.equals(user.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surName, dateOfExpirity, identificationNumber, mail, pass, role);
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", User.class.getSimpleName() + "[", "]")
                .add("name='" + name + "'")
                .add("surName='" + surName + "'")
                .add("dateOfExpirity='" + dateOfExpirity + "'")
                .add("identificationNumber='" + identificationNumber + "'")
                .add("mail='" + mail + "'")
                .add("pass='" + pass + "'")
                .add("role=" + role)
                .toString();
    }
}
