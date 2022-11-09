package agh.ics.oop;
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
    public String toString(){
        Vector2d botleft = mapElements.get(0).getPosition();
        Vector2d upright = mapElements.get(0).getPosition();

        for (IMapElement el:mapElements) {
            botleft = el.getPosition().lowerLeft(botleft);
            upright = el.getPosition().upperRight(upright);
        }

        String s = visualizer.draw(botleft, upright);
        return s;
    }
}