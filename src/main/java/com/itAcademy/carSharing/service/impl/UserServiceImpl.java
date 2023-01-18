package com.itAcademy.carSharing.service.impl;

import com.itAcademy.carSharing.dao.impl.UserDaoImpl;
import com.itAcademy.carSharing.encryption.PasswordEncryption;
import com.itAcademy.carSharing.entity.User;
import com.itAcademy.carSharing.exception.DaoException;
import com.itAcademy.carSharing.exception.ServiceException;
import com.itAcademy.carSharing.service.UserService;
import com.itAcademy.carSharing.validator.ParametrValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;



public class UserServiceImpl implements UserService {
    private static final Logger logger = LogManager.getLogger();

    private static UserServiceImpl instance = new UserServiceImpl();

    private UserServiceImpl() {

    }

    public static UserServiceImpl getInstance() {
        return instance;
    }

    @Override
    public boolean register(String name, String surname, String dateOfExpirity, String drivingLicenseNumber,
                            String email, String password) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        try {
            if (ParametrValidator.validateNameOrSurname(name)&&
                    ParametrValidator.validateNameOrSurname(surname)&&
                    ParametrValidator.validateDateOfExpirity(dateOfExpirity)&&
                    ParametrValidator.validateDrivingLicenseNumber(drivingLicenseNumber)&&
                    ParametrValidator.validateEmail(email)&&
                    ParametrValidator.validatePassword(password)
            ) {
                User user = new User();
                user.setName(name);
                user.setSurName(surname);
                user.setDateOfExpirity(dateOfExpirity);
                user.setDrivingLicenseNumber(drivingLicenseNumber);
                user.setMail(email);
                String passwordEncrypted=PasswordEncryption.encrypt(password);
                user.setPass(passwordEncrypted);
                boolean match = userDao.insert(user);
                return match;
            } else {
                logger.error("invalid user data in serice");
                return false;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public boolean authenticate(String email, String password) throws ServiceException {
        UserDaoImpl userDao = UserDaoImpl.getInstance();
        boolean match = false;
        try {
            if (ParametrValidator.validateEmail(email)&&
                    ParametrValidator.validatePassword(password)) {
                String encryptPassword= PasswordEncryption.encrypt(password);
                match = userDao.authenticate(email,encryptPassword);
            } else {
                logger.error("invalid email or password");
                return match;
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        return match;
    }

}
