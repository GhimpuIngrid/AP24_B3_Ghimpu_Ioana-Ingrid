package org.example;

import lombok.*;


@ToString
@Getter
@Setter
public class Person implements Comparable<Person> {

    String name;
    String destination;
    int age;
    boolean isDriver;
    boolean isPassenger;

    public boolean getIsDriver() {
        return this.isDriver;
    }

    public boolean getIsPassenger() {
        return this.isPassenger;
    }

    public int getAge(){return this.age;}

    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }
}
