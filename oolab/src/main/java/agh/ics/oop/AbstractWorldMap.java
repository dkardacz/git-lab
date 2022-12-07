package agh.ics.oop;

import agh.ics.oop.gui.App;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{

    protected MapVisualizer visualizer = new MapVisualizer(this);


    //protected ArrayList<IMapElement> mapElements = new ArrayList<>();
    protected Map<Vector2d, IMapElement> mapElements = new HashMap<>();
    public MapBoundry mapBoundry = new MapBoundry(this);

    public boolean isOccupied(Vector2d position){
        return (objectAt(position)!=null);
    }

    public abstract boolean canMoveTo(Vector2d position);

    public boolean place(IMapElement el){
        System.out.print(mapBoundry);
        Vector2d pos = el.getPosition();
        if(isOccupied(pos)){
            throw new IllegalArgumentException(pos + " is already occupied, can't place");
        }
        else{
            mapElements.put(el.getPosition(),el);
            mapBoundry.addItem(el);
            return true;
        }
    }

    public Object objectAt(Vector2d position){
        if(mapElements.containsKey(position)){
            return mapElements.get(position);
        }
        return null;
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
        System.out.println("boundires: "+ mapBoundry.getLowerLeft() + ", " + mapBoundry.getUpperRight());
        String s = visualizer.draw(mapBoundry.getLowerLeft(), mapBoundry.getUpperRight());
        return s;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        IMapElement el = mapElements.get(oldPosition);
        mapElements.remove(oldPosition, el);
        mapElements.put(newPosition, el);
    }

    @Override
    public MapBoundry getMapBoundry() {
        return mapBoundry;
    }
}
