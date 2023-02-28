package com.shapran.action;

import com.shapran.util.UserInput;

public class FindTeacherByName implements Action{
    @Override
    public void execute() {
        String name = UserInput.getString();
        service.printTeacherByName(name);
        logger.info("Find teacher with input name or surname");
    }
}
