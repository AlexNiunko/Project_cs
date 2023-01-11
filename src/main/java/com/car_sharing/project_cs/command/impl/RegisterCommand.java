package com.car_sharing.project_cs.command.impl;


import com.car_sharing.project_cs.command.Command;
import com.car_sharing.project_cs.command.PagePath;
import com.car_sharing.project_cs.command.Router;
import jakarta.servlet.http.HttpServletRequest;

public class RegisterCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router=new Router();
        String page= PagePath.REGISTER;
        router.setPage(page);
        return router;
    }
}
