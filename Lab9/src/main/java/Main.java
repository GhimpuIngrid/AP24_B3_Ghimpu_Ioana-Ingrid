import entities.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class Main {
    public static void main(String[] args) {
        DB connection = new DB();
        EntityManagerFactory factory = connection.getEntityManagerFactory();
        EntityManager em = factory.createEntityManager();
        System.out.println("ok");

        AuthorRepository authorRepository = new AuthorRepository(em);

        Author author = new Author();
        author.setName("AAA");
        author.setId(7);

        authorRepository.create(author);
        System.out.println("ok");

        Author author1 = authorRepository.findById(4);
        if (author1 != null) {
            System.out.println(author1);
        }
        else{
            System.out.println("author not found");
        }

        Author author2 = authorRepository.findByName("AAA");
        if (author2 != null) {
            System.out.println(author2);
        }
        else{
            System.out.println("author not found");
        }
        em.close();
        factory.close();
    }
}
