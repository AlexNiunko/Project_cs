package com.car_sharing.project_cs.command.impl;

import com.car_sharing.project_cs.command.Command;
import com.car_sharing.project_cs.command.PagePath;
import com.car_sharing.project_cs.command.Router;
import jakarta.servlet.http.HttpServletRequest;

public class DefaultCommand implements Command {
    @Override
    public Router execute(HttpServletRequest request) {
        Router router=new Router();
        router.setPage(PagePath.INDEX);
        return router;
    }
}
