package com.shapran.action;

public class FindAverageGrade implements Action{

    @Override
    public void execute() {
        service.printAverageGrade();
        logger.info("The average grade of group is find");
    }
}
