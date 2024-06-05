package org.example;

import java.util.*;

public class Problem {
    @Test
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

    @Test
    public LinkedList<Person> getDrivers(List<Person> people){
        List<Person> drivers = new LinkedList<>();
        drivers = people.stream().filter(person -> person.getIsDriver()).toList();
        return (LinkedList<Person>) drivers;
    }

    @Test
    public TreeSet<Person> getPassengers (List<Person> people){

        List<Person>passengers = people.stream().filter(person -> person.getIsPassenger()).toList();
        TreeSet<Person> orderedPassengers = new TreeSet<>(passengers);

        return orderedPassengers;
    }

    @Test
    public LinkedList<Person> orderDriversByAge(List<Person> drivers){
        return (LinkedList<Person>) drivers.stream().sorted(Comparator.comparing(Person::getAge)).toList();
    }

    @Test
    public List<Location> getLocations(){

        return List.of();
    }
}
