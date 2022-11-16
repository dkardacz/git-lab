package agh.ics.oop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected MapVisualizer visualizer = new MapVisualizer(this);
    //protected ArrayList<IMapElement> mapElements = new ArrayList<>();
    protected Map<Vector2d, IMapElement> mapElements = new HashMap<>();
    public boolean isOccupied(Vector2d position){
        return (objectAt(position)!=null);
    }

    public abstract boolean canMoveTo(Vector2d position);

    public boolean place(IMapElement el){
        if(isOccupied(el.getPosition())){
            return false;
        }
        else{
            mapElements.put(el.getPosition(),el);
            return true;
        }
    }

    public Object objectAt(Vector2d position){
        return mapElements.get(position);
    }
    public Map<Vector2d, IMapElement> getMapElements(){
        return mapElements;
    }
    public Map<Vector2d, Animal> getAnimals(){
        Map<Vector2d, Animal> animals = new HashMap<>();
        for (Map.Entry<Vector2d, IMapElement> entry: mapElements.entrySet()) {
            Vector2d key = entry.getKey();
            IMapElement value = entry.getValue();

            if(value instanceof Animal){
                animals.put(key, (Animal) value);
            }
        }
        return animals;
    }

    public ArrayList<Animal> getAnimalList() {
        ArrayList<Animal> animals = new ArrayList<>();
        for (Map.Entry<Vector2d, IMapElement> entry: mapElements.entrySet()) {
            Vector2d key = entry.getKey();
            IMapElement value = entry.getValue();

            if(value instanceof Animal){
                animals.add((Animal) value);
            }
        }
        return animals;
    }

    public abstract Vector2d getLowerLeftCorner();
    public abstract Vector2d getUpperRightCorner();

    public String toString(){
        String s = visualizer.draw(getLowerLeftCorner(), getUpperRightCorner());
        return s;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement el = mapElements.get(oldPosition);
        mapElements.remove(oldPosition, el);
        mapElements.put(newPosition, el);
    }
}
