package com.car_sharing.project_cs.command.impl;


import com.car_sharing.project_cs.command.*;
import com.car_sharing.project_cs.encryption.PasswordEncryption;
import com.car_sharing.project_cs.exception.CommandException;
import com.car_sharing.project_cs.exception.ServiceException;
import com.car_sharing.project_cs.service.UserService;
import com.car_sharing.project_cs.service.impl.UserServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginCommand implements Command {
    static Logger logger = LogManager.getLogger();
    @Override
    public Router execute(HttpServletRequest request) throws CommandException {
        Router router=new Router();
        HttpSession session=request.getSession();
        String login=request.getParameter(ParameterName.E_MAIL);
        String password=request.getParameter(ParameterName.PASSWORD);
        String passwordEncrypted= PasswordEncryption.encrypt(password);
        UserService userService= UserServiceImpl.getInstance();
        String page;
        try {
            if( (userService.authenticate(login,passwordEncrypted)) ){
                request.setAttribute(AttributeName.USER,login);
                session.setAttribute(AttributeName.USER,login);
                page = PagePath.MAIN;
                router.setRedirect();
                router.setPage(page);
                logger.info("Hello");
            } else {
                request.setAttribute("login_msg","incorrect login or password");
                page = PagePath.INDEX;
                router.setPage(page);
            }
        } catch (ServiceException e) {
            throw new CommandException(e);
        }
        return router;
    }
}
