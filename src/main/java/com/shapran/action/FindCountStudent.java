package com.shapran.action;

public class FindCountStudent implements Action{
    @Override
    public void execute() {
        service.printNumberOfStudentInGroup();
        logger.info("Find count of student in group");
    }
}
