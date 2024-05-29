package com.example.ClientApp;

import lombok.Getter;

public class Author {
    @Getter
    private int id;
    @Getter
    private String name;

    public Author(int id, String name){

        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "ID: " + this.id + " Name: " + this.name;
    }
}
