package com.example.ClientApp;

import com.example.ClientApp.Author;
import com.example.ClientApp.Genre;
import lombok.Getter;

import java.time.LocalDate;
import java.util.Date;

public class Book {
    @Getter
    private int id;
    @Getter
    private String title;
    @Getter
    private int authId;
    @Getter
    private int genId;
    @Getter
    private int date;
    @Getter
    private int numberOfPages;
    private Author auth;
    private Genre gen;

    public Book(int id, String title, int authId, int genId, int date, int numberOfPages){
        this.id = id;
        this.title = title;
        this.authId = authId;
        this.genId = genId;
        this.date = date;
        this.numberOfPages = numberOfPages;
    }

    @Override
    public String toString() {
        return "Cartea " + this.getTitle() + " este scrisa de " + this.getAuthId()
                + ", este o carte de " + this.getGenId() + ", a fost publicata in " +
                this.getDate() + " si are " + this.numberOfPages + " pagini.";
    }
}

