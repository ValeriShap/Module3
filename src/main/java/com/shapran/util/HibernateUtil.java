package com.shapran.util;

import org.flywaydb.core.Flyway;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {
    private static EntityManagerFactory entityManagerFactory;

    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            entityManagerFactory =
                    Persistence.createEntityManagerFactory("persistence");
        }
        return entityManagerFactory.createEntityManager();
    }
    public static Flyway migrationToBd(){
        return Flyway.configure()
                .dataSource("jdbc:postgresql://localhost:5432/module", "postgres", "6494")
                .baselineOnMigrate(true)
                .locations("db/migration")
                .load();
    }

}
