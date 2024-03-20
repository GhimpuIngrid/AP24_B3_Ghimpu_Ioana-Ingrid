package org.example;

import lombok.ToString;

@ToString
public class Passenger extends Person{

    private boolean taken;

    public Passenger(){
        this.taken = false;
    }

}