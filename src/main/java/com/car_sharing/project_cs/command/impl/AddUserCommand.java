package com.car_sharing.project_cs.command.impl;


import com.car_sharing.project_cs.command.Command;
import com.car_sharing.project_cs.command.PagePath;
import com.car_sharing.project_cs.command.ParameterName;
import com.car_sharing.project_cs.command.Router;
import com.car_sharing.project_cs.encryption.PasswordEncryption;
import com.car_sharing.project_cs.exception.CommandException;
import com.car_sharing.project_cs.exception.ServiceException;
import com.car_sharing.project_cs.service.UserService;
import com.car_sharing.project_cs.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

public class AddUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router=new Router();
        String page;
        String name=request.getParameter(ParameterName.NAME);
        String surname=request.getParameter(ParameterName.SURNAME);
        String dateOfExpirity= request.getParameter(ParameterName.DATE_OF_EXPIRITY);
        String identification_number=request.getParameter(ParameterName.IDENTIFICATION_NUMBER);
        String eMail=request.getParameter(ParameterName.E_MAIL);
        String password=request.getParameter(ParameterName.PASSWORD);
        String passwordEncrypted= PasswordEncryption.encrypt(password);
        UserService userService= UserServiceImpl.getInstance();
        try {
            if( (userService.register(name,surname,dateOfExpirity,identification_number,eMail,passwordEncrypted)) ){
    //            request.setAttribute("user",name);
                router.setRedirect();
                page = PagePath.MAIN;
                router.setPage(page);
            } else {
                request.setAttribute("login_msg","incorrect login or password");
                page = PagePath.REGISTER;
                router.setPage(page);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return router;
    }



}
