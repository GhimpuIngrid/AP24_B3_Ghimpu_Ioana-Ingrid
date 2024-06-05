package org.example;

import java.util.List;


public class Road {
    private String start;
    private String destination;
    private List<Location> stops;

    public Road(String start, String destination){
        this.start = start;
        this.destination = destination;
        this.setStops(RandomGen.genStops());
    }

    @Test
    public void setStops(List<Location> stops){
        for(int i = 0; i < stops.size(); i++)
            this.addStops(stops.get(i));
    }

    @Test
    public void addStops(Location l){
        this.stops.add(l);
    }

    @Test
    public String getStart(){
        return this.start;
    }

    public String getDestination(){
        return this.destination;
    }
}
