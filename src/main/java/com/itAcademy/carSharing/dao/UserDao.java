package com.itAcademy.carSharing.dao;

import com.itAcademy.carSharing.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login,String password) throws DaoException;
}
