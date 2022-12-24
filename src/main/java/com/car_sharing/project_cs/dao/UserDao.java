package com.car_sharing.project_cs.dao;

public interface UserDao {
    boolean authenticate(String login,String password);
}
