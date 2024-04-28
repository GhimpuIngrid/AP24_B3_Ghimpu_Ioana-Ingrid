package org.example;

import java.util.Date;

public class Book {
    private int id;
    private String title;
    private int authId;
    private int genId;
    private Date date;
    private int numberOfPages;
    private Auth auth;
    private Genre gen;

    public Book(int id, String title, int authId, int genId, Date date, int numberOfPages){
        this.id = id;
        this.title = title;
        this.authId = authId;
        this.genId = genId;
        this.date = date;
        this.numberOfPages = numberOfPages;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getAuthId() {
        return authId;
    }

    public int getGenId() {
        return genId;
    }

    public Date getDate() {
        return date;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public String toString() {
        return "Cartea " + this.getTitle() + "este scrisa de " + this.getAuthId()
                + ", este o carte de " + this.getGenId() + ", a fost publicata in " +
                this.getDate() + " si are " + this.numberOfPages + " pagini.";
    }
}
