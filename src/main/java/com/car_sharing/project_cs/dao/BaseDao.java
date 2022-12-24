package com.car_sharing.project_cs.dao;

import com.car_sharing.project_cs.entity.AbstractEntity;


import java.util.List;

public abstract class BaseDao<T extends AbstractEntity> {
    public  abstract  boolean insert(T t);
    public  abstract  boolean delete(T t);
    public abstract List<T> findAll(T t);
    public abstract T update(T t);
}
