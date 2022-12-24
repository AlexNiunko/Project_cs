package com.car_sharing.project_cs.command.impl;

import com.example.carSharing.command.Command;
import com.example.carSharing.service.UserService;
import com.example.carSharing.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;

import java.sql.Date;

public class AddUserCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page;
        String name=request.getParameter("name");
        String surname=request.getParameter("surname");
        Date dateOfIssue= Date.valueOf(request.getParameter("date_of_issue"));
        Date dateOfExpirity= Date.valueOf((request.getParameter("date_of_expirity")));
        String identification_number=request.getParameter("identification_number");
        String eMail=request.getParameter("e_mail");
        String password=request.getParameter("password");
        UserService userService= UserServiceImpl.getInstance();
        if( (userService.register(name,surname,dateOfIssue,dateOfExpirity,identification_number,eMail,password)) ){
//            request.setAttribute("user",name);
            page = "pages/main.jsp";
        } else {
            request.setAttribute("login_msg","incorrect login or password");
            page = "pages/register.jsp";
        }

        return page;
    }
}
