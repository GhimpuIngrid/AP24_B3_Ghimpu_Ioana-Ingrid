package org.example.entities;

@Entity
@Table(name="Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AID")
    private int id;

    @Column(name = "AuthName")
    private String name;

    public int getId(){return this.id;}
    public String getName(){return this.name;}

}
