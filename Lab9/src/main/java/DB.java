import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DB {
    private static EntityManagerFactory factory;

    static{
        factory = Persistence.createEntityManagerFactory("default");
    }

    public EntityManagerFactory getEntityManagerFactory(){
        return factory;
    }

    public void close(){
        factory.close();
    }
}
