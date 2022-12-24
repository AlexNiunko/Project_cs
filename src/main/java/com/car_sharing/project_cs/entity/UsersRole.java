package com.car_sharing.project_cs.entity;

public enum UsersRole {
    ADMIN(1),
    CUSTOMER(2);
    private int id;

    UsersRole(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
