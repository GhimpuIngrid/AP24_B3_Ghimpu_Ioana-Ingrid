package entities;

import jakarta.persistence.*;

@Entity
@Table(name="Authors")
@NamedQuery(name = "findByName", query = "SELECT a FROM Author a WHERE a.name = :name")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private int id;

    @Column(name = "AuthName")
    private String name;

    public int getId(){return this.id;}
    public String getName(){return this.name;}

    public void setName(String s) {
        this.name = s;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Author [id=" + id + ", name=" + name + "]";
    }
}
