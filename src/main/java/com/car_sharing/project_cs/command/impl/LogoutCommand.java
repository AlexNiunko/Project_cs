package com.car_sharing.project_cs.command.impl;

import com.car_sharing.project_cs.command.Command;
import com.car_sharing.project_cs.command.PagePath;
import com.car_sharing.project_cs.command.Router;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class LogoutCommand implements Command {
    static Logger logger = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) {
        logger.info("Hello logout");
        Router router=new Router();
        HttpSession session= request.getSession();
        session.invalidate();
        router.setRedirect();
        router.setPage("/index.jsp");
        return router;
    }
}
