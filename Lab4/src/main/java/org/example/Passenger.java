package org.example;

import lombok.*;

import java.util.Comparator;


@ToString
@Getter
@Setter
public class Passenger extends Person {

    private boolean taken;

    public Passenger(String name, int age, boolean isDriver){
        this.taken = false;
        this.name = name;
        this.age = age;
        this.isDriver = isDriver;
        this.isPassenger = !this.isDriver;
    }

    public String toString(){

        return this.getClass() + " " + this.getAge();
    }
}