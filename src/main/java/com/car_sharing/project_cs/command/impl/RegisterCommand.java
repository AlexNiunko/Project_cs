package com.car_sharing.project_cs.command.impl;


import com.car_sharing.project_cs.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        String page= "pages/register.jsp" ;
        return page;
    }
}
