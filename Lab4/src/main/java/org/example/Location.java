package org.example;

public class Location {

    private Road onRoad;
    private String name;

    public Location(Road r, String name){
        this.onRoad = r;
        this.name = name;
        r.addStops(this);
    }
}
