package org.example;

public class Passenger extends Person {

    private boolean taken;

    public Passenger(String name, int age, boolean isDriver){
        this.taken = false;
        this.name = name;
        this.age = age;
        this.isDriver = isDriver;
        this.isPassenger = !this.isDriver;
    }

    @Test
    public String toString(){

        return this.getClass() + " " + this.getAge();
    }
}