package agh.ics.oop;

import java.util.Comparator;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class MapBoundry implements IPositionChangeObserver {

    IWorldMap map;
    Vector2d lowerLeft;
    Vector2d upperRight;
    Comparator<IMapElement> comparatorX = (IMapElement o1, IMapElement o2) -> {
        if(o1 == null && o2 !=null){
            return 1;
        }
        else if(o1 == null && o2 == null){
            return 0;
        }
        else if(o1 != null && o2 == null){
            return -1;
        }
            else{
            if (o1.getPosition().x < o2.getPosition().x) {
                return -1;
            } else if (o1.getPosition().x > o2.getPosition().x) {
                return 1;
            } else {
                if (o1.getPosition().y < o2.getPosition().y) {
                    return -1;
                } else if (o1.getPosition().y > o2.getPosition().y) {
                    return 1;
                } else {
                    if ((o1 instanceof Animal) && (o2 instanceof Animal)) {
                        return 0;
                    } else if ((o1 instanceof Grass) && (o2 instanceof Animal)) {
                        return -1;
                    } else if ((o1 instanceof Animal) && (o2 instanceof Grass)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    };

    Comparator<IMapElement> comparatorY = (IMapElement o1, IMapElement o2) -> {
        if(o1 == null && o2 !=null){
            return 1;
        }
        else if(o1 == null && o2 == null){
            return 0;
        }
        else if(o1 != null && o2 == null){
            return -1;
        }
        else{
            if (o1.getPosition().y < o2.getPosition().y) {
                return -1;
            } else if (o1.getPosition().y > o2.getPosition().y) {
                return 1;
            } else {
                if (o1.getPosition().x < o2.getPosition().x) {
                    return -1;
                } else if (o1.getPosition().x > o2.getPosition().x) {
                    return 1;
                } else {
                    if ((o1 instanceof Animal) && (o2 instanceof Animal)) {
                        return 0;
                    } else if ((o1 instanceof Grass) && (o2 instanceof Animal)) {
                        return -1;
                    } else if ((o1 instanceof Animal) && (o2 instanceof Grass)) {
                        return 1;
                    } else {
                        return 0;
                    }
                }
            }
        }
    };

    SortedSet<IMapElement> sortedX = new TreeSet<>(comparatorX);
    SortedSet<IMapElement> sortedY = new TreeSet<>(comparatorY);

    public MapBoundry(IWorldMap map){
        this.map = map;
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Map<Vector2d, IMapElement> mapElements = map.getMapElements();
        IMapElement el = mapElements.get(newPosition);
        mapElements.remove(el);
        sortedY.remove(el);
        sortedX.remove(el);
        mapElements.put(newPosition, el);
        sortedY.add(el);
        sortedX.add(el);
    }

    public void addItem(IMapElement el) {
        Map<Vector2d, IMapElement> mapElements = map.getMapElements();
        sortedX.add(el);
        sortedY.add(el);
        mapElements.put(el.getPosition(), el);
        lowerLeft = new Vector2d(sortedX.first().getPosition().x, sortedY.first().getPosition().y);
        upperRight = new Vector2d(sortedX.last().getPosition().x, sortedY.last().getPosition().y);
    }

    public Vector2d getLowerLeft(){
        return lowerLeft;
    }
    public Vector2d getUpperRight(){
        return upperRight;
    }

}

