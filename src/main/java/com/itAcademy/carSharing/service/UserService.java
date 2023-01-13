package com.itAcademy.carSharing.service;

import com.itAcademy.carSharing.exception.ServiceException;

public interface UserService {
    boolean register(String name, String surname,String dateOfExpirity,String identificationNumber,
                     String email,String password) throws ServiceException;

    boolean authenticate(String email, String password) throws ServiceException;

}
