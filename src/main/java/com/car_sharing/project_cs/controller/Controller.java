package com.car_sharing.project_cs.controller;

import java.io.*;
import java.rmi.ServerException;

import com.car_sharing.project_cs.command.Command;
import com.car_sharing.project_cs.command.CommandType;
import com.car_sharing.project_cs.command.ParameterName;
import com.car_sharing.project_cs.command.Router;
import com.car_sharing.project_cs.exception.CommandException;
import com.car_sharing.project_cs.pool.ConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "controller", urlPatterns = "/controller")
public class Controller extends HttpServlet {
    static Logger logger = LogManager.getLogger();

    public void init() {
        ConnectionPool.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
       process(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException {
        process(req, resp);
    }

    private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String commandStr = request.getParameter(ParameterName.COMMAND);
            Command command = CommandType.defineCommand(commandStr.toUpperCase());
            Router router=command.execute(request);
            if (router.getType().equals(Router.Type.FORWARD)){
                request.getRequestDispatcher(router.getPage()).forward(request,response);
                logger.info("Hello forward");
            } else if (router.getType().equals(Router.Type.REDIRECT)){
                logger.info("Hello redirect");
                response.sendRedirect(router.getPage());
            }
        } catch (CommandException | IOException e) {
            throw new ServletException(e);
        }
    }


    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }

}