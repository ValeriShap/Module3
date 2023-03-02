package com.shapran.action;

import com.shapran.model.Student;

public class CreateStudent implements Action{
    @Override
    public void execute() {
        Student student = service.createStudent();
        System.out.println(student);
        logger.info("Student was created");
    }
}
