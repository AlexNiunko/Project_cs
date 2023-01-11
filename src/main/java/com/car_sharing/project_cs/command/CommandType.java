package com.car_sharing.project_cs.command;


import com.car_sharing.project_cs.command.impl.*;

import java.util.Arrays;
import java.util.Optional;

public enum CommandType {
    ADD(new AddUserCommand()),
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DEFAULT(new DefaultCommand()),
    REGISTER(new RegisterCommand());

    Command command;

    CommandType(Command command) {
        this.command = command;
    }

    private Command getCommand() {
        return command;
    }

    public static Command defineCommand(String commandStr){
        CommandType currentCommand ;
        Optional<String>ifExist= Arrays.stream(CommandType.values())
                .map(Enum::toString)
                .filter(s->s.toUpperCase().matches(commandStr.toUpperCase()))
                .findAny();
        if (ifExist.isPresent()){
            currentCommand=CommandType.valueOf(commandStr.toUpperCase());
        }  else {
            currentCommand=CommandType.DEFAULT;
        }
        return currentCommand.command;
    }
}