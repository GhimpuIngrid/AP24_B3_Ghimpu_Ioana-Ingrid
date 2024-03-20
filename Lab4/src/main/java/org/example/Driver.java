package org.example;

import lombok.ToString;

@ToString
public class Driver extends Person{

    private boolean free;

    public Driver(){this.free = true;}

}