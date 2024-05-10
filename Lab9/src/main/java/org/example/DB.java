package org.example;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DB {
    private static EntityManagerFactory factory;

    static{
        factory = Persistence.createEntityManagerFactory("Library");
    }

    public static EntityManagerFactory getEntityManagerFactory(){
        return factory;
    }

    public static void close(){
        factory.close();
    }
}
