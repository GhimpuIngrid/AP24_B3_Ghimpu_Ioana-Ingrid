package org.example;

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
