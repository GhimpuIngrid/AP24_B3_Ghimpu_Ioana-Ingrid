package org.example;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Person {
    private String name;
    private String destination;
    private int age;
    private boolean isDriver;
    private boolean isPassenger;

    public Person(String name, int age, boolean isDriver, boolean isPassenger){
        this.name = name;
        this.age = age;
        if(isDriver == isPassenger){
            System.out.println("O pesroana nu poate fi si sofer si pasager in acelasi timp");
        }
        else {
            this.isDriver = isDriver;
            this.isPassenger = isPassenger;
        }
    }
}
