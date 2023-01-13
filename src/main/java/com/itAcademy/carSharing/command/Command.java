package com.itAcademy.carSharing.command;

import com.itAcademy.carSharing.exception.CommandException;
import jakarta.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    Router execute(HttpServletRequest request) throws CommandException;

}
