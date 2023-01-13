package com.itAcademy.carSharing.command.impl;

import com.itAcademy.carSharing.command.Command;
import com.itAcademy.carSharing.command.PagePath;
import com.itAcademy.carSharing.command.Router;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router=new Router();
        router.setPage(PagePath.INDEX);
        return router;
    }
}
