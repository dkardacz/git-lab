package agh.ics.oop;
import java.util.Map;
import java.util.Random;
import java.util.ArrayList;
import java.util.Vector;

public class GrassField extends AbstractWorldMap{

    int count;

    public GrassField(int n){
        count = n;
        for (int i = 0; i < n; i++) {
            generateGrass();
        }
    }

   public void generateGrass(){
       Random rand = new Random();
       double upperBound = Math.floor(Math.sqrt(count*10));
       int a = rand.nextInt((int) upperBound);
       int b = rand.nextInt((int) upperBound);
       Grass g = new Grass(new Vector2d(a,b));
       while(!place(g)){
           a = rand.nextInt((int) upperBound);
           b = rand.nextInt((int) upperBound);
           g = new Grass(new Vector2d(a,b));
       }
   }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(!(isOccupied(position))){
            return true;
        }
        else{
            return !(objectAt(position) instanceof Animal);
        }
    }

    @Override
    public Vector2d getLowerLeftCorner(){
        Vector2d lowleft = (Vector2d) mapElements.keySet().toArray()[0];
        for (Map.Entry<Vector2d, IMapElement> entry: mapElements.entrySet()) {
            Vector2d key = entry.getKey();
            lowleft = key.lowerLeft(lowleft);
        }
        return lowleft;
    }

    @Override
    public Vector2d getUpperRightCorner(){

        Vector2d upright = (Vector2d) mapElements.keySet().toArray()[0];

        for (Map.Entry<Vector2d, IMapElement> entry: mapElements.entrySet()) {
            Vector2d key = entry.getKey();
            upright = key.upperRight(upright);
        }
        return upright;
    }

}