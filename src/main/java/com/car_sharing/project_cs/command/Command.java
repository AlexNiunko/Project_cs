package com.car_sharing.project_cs.command;

import com.car_sharing.project_cs.exception.CommandException;
import com.car_sharing.project_cs.exception.ServiceException;
import jakarta.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    Router execute(HttpServletRequest request) throws CommandException;

}
