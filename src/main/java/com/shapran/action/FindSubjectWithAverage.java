package com.shapran.action;

public class FindSubjectWithAverage implements Action{

    @Override
    public void execute() {
        service.getSubjectWithBestOrWorstGrade();
        logger.info("Create subject with lowest and bigger average grade");
    }
}
