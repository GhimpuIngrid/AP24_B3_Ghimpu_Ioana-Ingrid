import entities.Author;
import jakarta.persistence.EntityManager;

public class AuthorRepository {
    private EntityManager entityManager;

    public AuthorRepository(EntityManager em) {
        this.entityManager = em;
    }

    public void create(Author author) {
        entityManager.getTransaction().begin();
        entityManager.merge(author);
        entityManager.getTransaction().commit();
    }

    public Author findById(int id){
        Author author = entityManager.find(Author.class, id);
        return author;
    }

    public Author findByName(String name) {
        return entityManager.createNamedQuery("findByName", Author.class)
                .setParameter("name", name).getSingleResult();
    }
}
