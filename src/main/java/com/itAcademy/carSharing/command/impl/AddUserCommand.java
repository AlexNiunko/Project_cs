package com.itAcademy.carSharing.command.impl;


import com.itAcademy.carSharing.command.*;
import com.itAcademy.carSharing.encryption.PasswordEncryption;
import com.itAcademy.carSharing.exception.CommandException;
import com.itAcademy.carSharing.exception.ServiceException;
import com.itAcademy.carSharing.service.UserService;
import com.itAcademy.carSharing.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class AddUserCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router=new Router();
        String page;
        HttpSession session= request.getSession();
        String name=request.getParameter(ParameterName.NAME);
        String surname=request.getParameter(ParameterName.SURNAME);
        String dateOfExpirity= request.getParameter(ParameterName.DATE_OF_EXPIRITY);
        String identificationNumber=request.getParameter(ParameterName.IDENTIFICATION_NUMBER);
        String eMail=request.getParameter(ParameterName.E_MAIL);
        String password=request.getParameter(ParameterName.PASSWORD);
        UserService userService= UserServiceImpl.getInstance();
        try {
            if( (userService.register(name,surname,dateOfExpirity,identificationNumber,eMail,password)) ){
                request.setAttribute("user",name);
                router.setRedirect();
                page = PagePath.MAIN;
                router.setPage(page);
            } else {
                request.setAttribute(AttributeName.REGISTRATION_MSG,"incorrect data input");
                session.setAttribute(AttributeName.REGISTRATION_MSG,"incorrect data input");
                router.setRedirect();
                page = PagePath.REGISTER;
                router.setPage(page);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return router;
    }



}
