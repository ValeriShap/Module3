package com.shapran.action;

public class ExitAction implements Action{
    @Override
    public void execute() {
        System.out.println("Goodbye!");
        logger.info("The program finished");
        System.exit(0);
    }
}
