package com.car_sharing.project_cs.service.impl;

import com.car_sharing.project_cs.dao.impl.UserDaoImpl;
import com.car_sharing.project_cs.entity.User;
import com.car_sharing.project_cs.exception.DaoException;
import com.car_sharing.project_cs.exception.ServiceException;
import com.car_sharing.project_cs.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class UserServiceImpl implements UserService {
    static final Logger logger = LogManager.getLogger();

    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        return instance;
    }
    @Override
    public boolean register(String name, String surname,String dateOfExpirity,String identificationNumber,
                            String email,String password) throws ServiceException {
        User user=new User(name,surname,dateOfExpirity,identificationNumber,email,password);
        UserDaoImpl userDao=UserDaoImpl.getInstance();
        boolean match;
        try {
            match = userDao.insert(user);
            return match;
        } catch (DaoException e) {
            throw new ServiceException(e);
        }

    }



    @Override
    public boolean authenticate(String e_mail, String password) throws ServiceException {
        UserDaoImpl userDao=UserDaoImpl.getInstance();
        boolean match= false;
        try {
            match = userDao.authenticate(e_mail, password);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }

}
