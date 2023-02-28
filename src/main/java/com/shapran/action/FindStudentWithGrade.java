package com.shapran.action;

import com.shapran.util.UserInput;

public class FindStudentWithGrade implements Action{
    @Override
    public void execute() {
        double grade = UserInput.getDouble();
        service.printStudentWithAverageGrade(grade);
        logger.info("Get student with average grade over user input");
    }
}
