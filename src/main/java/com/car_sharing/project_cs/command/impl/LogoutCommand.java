package com.car_sharing.project_cs.command.impl;

import com.example.carSharing.command.Command;
import jakarta.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {
    @Override
    public String execute(HttpServletRequest request) {
        return null;
    }
}
