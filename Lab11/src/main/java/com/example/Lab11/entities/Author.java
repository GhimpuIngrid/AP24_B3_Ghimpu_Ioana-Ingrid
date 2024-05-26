package com.example.Lab11.entities;

public class Author {

    private int id;
    private String name;

    public Author(int id, String name){
         this.id = id;
         this.name = name;
    }

    public int getId() {
            return this.id;
        }

    public String getName() {
            return this.name;
        }

    @Override
    public String toString() {
            return "ID: " + this.id + " Name: " + this.name;
        }
}
