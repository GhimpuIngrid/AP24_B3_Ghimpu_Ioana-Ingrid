package org.example;

import java.util.*;

public class Problem {
    public List<Person> getPeople(){
        List<Person> people = new ArrayList<>();

        for(int i = 0; i < 8; i++){
            boolean val = RandomGen.bool();

            if(val)
                people.add(new Driver("person"+i, RandomGen.genAge(), val));
            else people.add(new Passenger("person"+i, RandomGen.genAge(), val));
        }
        return people;
    }

    public LinkedList<Person> getDrivers(List<Person> people){
        List<Person> drivers = new LinkedList<>();
        drivers = people.stream().filter(person -> person.getIsDriver()).toList();
        return drivers;
    }

    public TreeSet<Person> getPassengers (List<Person> people){

        List<Person>passengers = people.stream().filter(person -> person.getIsPassenger()).toList();
        TreeSet<Person> orderedPassengers = new TreeSet<>(passengers);

        return orderedPassengers;
    }

    public LinkedList<Person> orderDriversByAge(List<Person> drivers){
        return drivers.stream().sorted(Comparator.comparing(Person::getAge)).toList();
    }

    public List<Location> getLocations(){

    }
}
