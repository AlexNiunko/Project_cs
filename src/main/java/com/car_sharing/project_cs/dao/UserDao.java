package com.car_sharing.project_cs.dao;

import com.car_sharing.project_cs.exception.DaoException;

public interface UserDao {
    boolean authenticate(String login,String password) throws DaoException;
}
