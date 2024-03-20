package org.example;

import java.util.*;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        List<Person> people = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            boolean val = RandomGen.bool();

            if(val)
                people.add(new Driver("person"+i, RandomGen.genAge(), val));
            else people.add(new Passenger("person"+i, RandomGen.genAge(), val));
        }

        List<Person> drivers = new LinkedList<>();
        drivers = people.stream().filter(person -> person.getIsDriver()).toList();

        List<Person>passengers = people.stream().filter(person -> person.getIsPassenger()).toList();

        //TreeSet is already ordered
        TreeSet<Person> orderedPassengers = new TreeSet<>(passengers);

        drivers.stream().sorted(Comparator.comparing(Person::getAge)).forEach(System.out::println);

        System.out.println(orderedPassengers);
    }
}