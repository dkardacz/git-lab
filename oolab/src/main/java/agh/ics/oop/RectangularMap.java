package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap extends AbstractWorldMap{
    private int width;
    private int height;

    private MapVisualizer visualizer = new MapVisualizer(this);


    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }


    boolean isOutOfBounds(Vector2d position){
        return (position.x>width||position.y>height||position.x<0||position.y<0);
    }

    @Override
    public boolean canMoveTo(Vector2d position){

        if(!(isOccupied(position)||isOutOfBounds(position))){
            return true;
        }
        else if (isOccupied(position)){
            return !(objectAt(position) instanceof Animal);
        }
        else{
            return false;
        }
    }




    @Override
    public String toString(){
        String s = visualizer.draw(new Vector2d(0,0), new Vector2d(width,height));
        return s;
    }



}
