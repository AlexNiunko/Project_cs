package com.car_sharing.project_cs.command;

import com.example.carSharing.command.impl.AddUserCommand;
import com.example.carSharing.command.impl.LoginCommand;
import com.example.carSharing.command.impl.LogoutCommand;
import com.example.carSharing.command.impl.RegisterCommand;

public enum CommandType {
    ADD_USER(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    REGISTER(new RegisterCommand());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }

    public static Command defineCommand(String commandStr){
        CommandType currentCommand=CommandType.valueOf(commandStr.toUpperCase());
        return currentCommand.command;
    }
}