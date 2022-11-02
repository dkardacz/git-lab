package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private int width;
    private int height;

    private MapVisualizer visualizer = new MapVisualizer(this);

    private ArrayList<Animal> animals = new ArrayList<>();

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public boolean isOccupied(Vector2d position){
        for (Animal a: animals) {
            if(a.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    boolean isOutOfBounds(Vector2d position){
        return (position.x>width||position.y>height||position.x<0||position.y<0);
    }

    public boolean canMoveTo(Vector2d position){
        return (!(isOccupied(position)||isOutOfBounds(position)));
    }

    public boolean place(Animal animal){
        if(isOccupied(animal.getPosition())){
            return false;
        }
        else{
            animals.add(animal);
            return true;
        }
    }

    public Object objectAt(Vector2d position){
        for (Animal a: animals) {
            if (a.getPosition().equals(position)) {
                return a;
            }
        }
        return null;
    }

    public String toString(){
        String s = new String(visualizer.draw(new Vector2d(0,0), new Vector2d(width,height)));
        System.out.println(s);
        return s;
    }

    public ArrayList<Animal> getAnimals(){
        return animals;
    }

}
