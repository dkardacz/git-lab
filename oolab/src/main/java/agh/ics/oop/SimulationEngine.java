package agh.ics.oop;

import java.util.ArrayList;

public class SimulationEngine implements IEngine{
    private MoveDirection[] directions;
    private IWorldMap map;
    private Vector2d[] positions;

    public SimulationEngine(MoveDirection[] directions, IWorldMap map, Vector2d[] positions){
        this.directions = directions;
        this.map = map;
        this.positions = positions;
    }
    public void run(){
        for (Vector2d pos:positions) {
            Animal a = new Animal(map, pos);
            map.place(a);
        }
        int count = positions.length;
        int i = 0;
        ArrayList<Animal> animals = map.getAnimals();
        while(i < directions.length){
            Animal a = animals.get(i%count);
            a.move(directions[i]);
            i+=1;
        }
        map.toString();
    }
}
