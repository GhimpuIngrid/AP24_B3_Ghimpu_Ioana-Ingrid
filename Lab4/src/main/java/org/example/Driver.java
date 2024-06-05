package org.example;

public class Driver extends Person{

    private boolean free;
    private String destination;
    private String start;

    public Driver(String name, int age, boolean isDriver)
    {
        this.free = true;
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