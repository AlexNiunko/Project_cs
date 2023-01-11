package com.car_sharing.project_cs.service;

import com.car_sharing.project_cs.exception.DaoException;
import com.car_sharing.project_cs.exception.ServiceException;

public interface UserService {
    boolean register(String name, String surname,String dateOfExpirity,String identificationNumber,
                     String email,String password) throws ServiceException;

    boolean authenticate(String e_mail, String password) throws ServiceException;

}
