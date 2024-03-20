package org.example;

import lombok.*;

@ToString
@Getter
@Setter
public class Driver extends Person{

    private boolean free;

    public Driver(String name, int age, boolean isDriver)
    {
        this.free = true;
        this.name = name;
        this.age = age;
        this.isDriver = isDriver;
        this.isPassenger = !this.isDriver;
    }

     public String toString(){

         return this.getClass() + " " + this.getAge();
     }

}