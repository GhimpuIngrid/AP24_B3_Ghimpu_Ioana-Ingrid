package org.example;

import java.util.stream.IntStream;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var people = IntStream.rangeClosed(0, 7).mapToObj(i -> new Person("person"+i, i+30, )).toArray(Person[] :: new);


    }
}