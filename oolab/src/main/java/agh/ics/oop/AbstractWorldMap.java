package agh.ics.oop;

import java.util.ArrayList;

abstract class AbstractWorldMap implements IWorldMap{

    protected MapVisualizer visualizer = new MapVisualizer(this);
    protected ArrayList<IMapElement> mapElements = new ArrayList<>();
    public boolean isOccupied(Vector2d position){
        for (IMapElement el : mapElements) {
            if(el.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    public abstract boolean canMoveTo(Vector2d position);

    public boolean place(IMapElement el){
        if(isOccupied(el.getPosition())){
            return false;
        }
        else{
            mapElements.add(el);
            return true;
        }
    }

    public Object objectAt(Vector2d position){
        for (IMapElement el: mapElements) {
            if (el.getPosition().equals(position)) {
                return el;
            }
        }
        return null;
    }
    public ArrayList<IMapElement> getMapElements(){
        return mapElements;
    }
    public ArrayList<Animal> getAnimals(){
        ArrayList<Animal> animals = new ArrayList<>();
        for (IMapElement el:mapElements) {
            if(el instanceof Animal){
                animals.add((Animal) el);
            }
        }
        return animals;
    }

    public abstract String toString();
}
