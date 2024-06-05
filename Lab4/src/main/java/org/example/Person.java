package org.example;

public class Person implements Comparable<Person> {

    String name;
    String destination;
    int age;
    boolean isDriver;
    boolean isPassenger;

    @Test
    public boolean getIsDriver() {
        return this.isDriver;
    }

    @Test
    public boolean getIsPassenger() {
        return this.isPassenger;
    }

    @Test
    public int getAge(){return this.age;}

    @Override
    public int compareTo(Person o) {
        return this.getAge() - o.getAge();
    }
}
