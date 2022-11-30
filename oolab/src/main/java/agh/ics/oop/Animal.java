package agh.ics.oop;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Animal implements IMapElement {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    private ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        addObserver((IPositionChangeObserver) map.getMapBoundry());
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        addObserver((IPositionChangeObserver) map.getMapBoundry());
        this.position = initialPosition;
    }

    public String toString(){
        //String res = new String(position.toString() +", "+orientation.toString());
        String res = switch(orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
        return res;
    }

    public boolean isAt(Vector2d position){
        if(this.position.equals(position)){
            return true;
        }
        else{
            return false;
        }
    }

    public void move(MoveDirection dir){
        switch (dir){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                Vector2d oldpos = position;
                Vector2d newpos = position.add(orientation.toUnitVector());
                if(map.canMoveTo(newpos)){
                        if(map.isOccupied(newpos)){
                            if(map.objectAt(newpos) instanceof Grass){
                                map.getMapElements().remove(map.objectAt(newpos));
                                if(map instanceof GrassField){
                                    GrassField gmap = (GrassField) map;
                                    gmap.generateGrass();
                                }
                            }
                        }
                        position = newpos;
                        positionChanged(oldpos,newpos);
                        }
            }
            case BACKWARD -> {
                Vector2d oldpos = position;
                Vector2d newpos = position.subtract(orientation.toUnitVector());
                if(map.canMoveTo(newpos)){
                    if(map.isOccupied(newpos)){
                        if(map.objectAt(newpos) instanceof Grass){
                            map.getMapElements().remove(map.objectAt(newpos));
                            if(map instanceof GrassField){
                                GrassField gmap = (GrassField) map;
                                gmap.generateGrass();
                            }
                        }
                    }
                    position = newpos;
                    positionChanged(oldpos,newpos);
                }
            }
        }
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver o: observers) {
            o.positionChanged(oldPosition, newPosition);
        }
    }
    public Vector2d getPosition(){
        return position;
    }

}
