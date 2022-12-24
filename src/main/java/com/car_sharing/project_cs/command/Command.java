package com.car_sharing.project_cs.command;

import jakarta.servlet.http.HttpServletRequest;
@FunctionalInterface
public interface Command {
    String execute(HttpServletRequest request);

}
