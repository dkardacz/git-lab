package agh.ics.oop;

import agh.ics.oop.gui.App;

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


        ArrayList<Animal> animals = map.getAnimalList();
        int count = animals.toArray().length;
        for (int i = 0; i < directions.length; i++) {
            Animal a = animals.get(i%count);
            a.move(directions[i]);
        }
        System.out.println(map.toString());
    }
}
