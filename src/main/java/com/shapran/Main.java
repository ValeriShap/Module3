package com.shapran;

import com.shapran.util.HibernateUtil;
import com.shapran.util.UserInput;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        Flyway flyway = HibernateUtil.migrationToBd();
        flyway.clean();
        HibernateUtil.getEntityManager();
        flyway.migrate();

        UserInput userInput = new UserInput();
        userInput.start();
    }
}