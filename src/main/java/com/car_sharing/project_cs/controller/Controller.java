package com.car_sharing.project_cs.controller;

import java.io.*;

import com.car_sharing.project_cs.command.Command;
import com.car_sharing.project_cs.command.CommandType;
import com.car_sharing.project_cs.pool.ConnectionPool;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@WebServlet(name = "controller", value = "/controller")
public class Controller extends HttpServlet {
    static Logger logger= LogManager.getLogger();

    public void init() {
        ConnectionPool.getInstance();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        String commandStr=request.getParameter("command");
        Command command= CommandType.defineCommand(commandStr);
        String page=command.execute(request);
        request.getRequestDispatcher(page).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    public void destroy() {
        ConnectionPool.getInstance().destroyPool();
    }


}