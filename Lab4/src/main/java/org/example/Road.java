package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Road {
    private String start;
    private String destination;
    private List<Location> stops;

    public Road(String start, String destination){
        this.start = start;
        this.destination = destination;
        this.setStops(RandomGen.genStops());
    }

    public void setStops(List<Location> stops){
        for(int i = 0; i < stops.size(); i++)
            this.addStops(stops.get(i));
    }

    public void addStops(Location l){
        this.stops.add(l);
    }

    public String getStart(){
        return this.start;
    }

    public String getDestination(){
        return this.destination;
    }
}
