package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomGen {
    public static int genAge(){
        int min = 20;
        int max = 60;
        int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
        return random;
    }

    public static boolean bool(){
        Random val = new Random();
        return(val.nextBoolean());
    }

    public static List<Location> genStops(){
        List<Location> location = new ArrayList<>();


        return location;
    }
}
