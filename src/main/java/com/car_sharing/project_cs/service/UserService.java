package com.car_sharing.project_cs.service;

import java.sql.Date;

public interface UserService {
     boolean authenticate(String login,String password);
     boolean register(String name, String surname,
                      Date dateOfIssue, Date dateOfExpirity,
                      String identificationNumber, String pass, String mail);

}
