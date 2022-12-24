package com.car_sharing.project_cs.service.impl;

import com.example.carSharing.dao.impl.UserDaoImpl;
import com.example.carSharing.entity.User;
import com.example.carSharing.service.UserService;
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
    public boolean register(String name, String surname,
                            Date dateOfIssue, Date dateOfExpirity,
                            String identificationNumber, String pass, String mail) {
        User user=new User(name,surname, dateOfIssue,dateOfExpirity,identificationNumber,pass,mail);
        UserDaoImpl userDao=UserDaoImpl.getInstance();
        boolean match=userDao.insert(user);
        return match;
    }



    @Override
    public boolean authenticate(String login, String password) {
        //validate login pass + md5
        UserDaoImpl userDao=UserDaoImpl.getInstance();
        boolean match= userDao.authenticate(login, password);
        return match; // todo
    }

}
