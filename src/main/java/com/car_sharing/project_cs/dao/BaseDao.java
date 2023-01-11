package com.car_sharing.project_cs.dao;

import com.car_sharing.project_cs.entity.AbstractEntity;
import com.car_sharing.project_cs.exception.DaoException;


import java.util.List;

public abstract class BaseDao<T extends AbstractEntity> {
    public  abstract  boolean insert(T t) throws DaoException;
    public  abstract  boolean delete(T t) throws DaoException;
    public abstract List<T> findAll(T t) throws DaoException;
    public abstract T update(T t) throws DaoException;
}
