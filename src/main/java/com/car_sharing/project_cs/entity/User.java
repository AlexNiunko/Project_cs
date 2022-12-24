package com.car_sharing.project_cs.entity;

import java.sql.Date;

public class User extends AbstractEntity {
    private long idUser;
    private String name;
    private String surName;
    private Date dateOfIssue;
    private Date dateOfExpirity;
    private String identificationNumber;
    private String mail;
    private String pass;
    private UsersRole role;

    public User( String name, String surName, Date dateOfIssue,
                 Date dateOfExpirity, String identificationNumber, String mail, String pass) {
        this.name = name;
        this.surName = surName;
        this.dateOfIssue = dateOfIssue;
        this.dateOfExpirity = dateOfExpirity;
        this.identificationNumber = identificationNumber;
        this.mail = mail;
        this.pass = pass;
        this.role=UsersRole.CUSTOMER;
    }

    public long getIdUser() {
        return idUser;
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

    public void setIdentificationNumber(String identificationNumber) {
        this.identificationNumber = identificationNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public UsersRole getRole() {
        return role;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Date getDateOfExpirity() {
        return dateOfExpirity;
    }

    public void setDateOfExpirity(Date dateOfExpirity) {
        this.dateOfExpirity = dateOfExpirity;
    }

    public void setRole(UsersRole role) {
        this.role = role;
    }
}
