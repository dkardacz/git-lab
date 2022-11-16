package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassFieldTest {

    @Test
    public void testGenerateGrass(){
        GrassField map = new GrassField(10);
        Assertions.assertTrue(map.getMapElements().size()==10);
    }
    @Test
    public void testIsOccupied(){
        IWorldMap map = new GrassField(0);
        Grass g = new Grass(new Vector2d(1,1));
        Animal a = new Animal(map, new Vector2d(2,2));
        map.place(a);
        map.place(g);

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assertions.assertTrue(map.isOccupied(new Vector2d(1,1)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(3,4)));
    }

    @Test
    public void testCanMoveTo(){
        IWorldMap map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,2));
        map.place(a);

        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        Assertions.assertTrue(map.canMoveTo(new Vector2d(200,300)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(2,2)));
    }

    @Test
    public void testPlace(){
        IWorldMap map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,2));
        Assertions.assertTrue(map.place(a));

        Animal b = new Animal(map,new Vector2d(2,2));
        Assertions.assertFalse(map.place(b));
    }

    @Test
    public void testObjectAt(){
        IWorldMap map = new GrassField(10);
        Animal a = new Animal(map, new Vector2d(2,2));
        map.place(a);

        Assertions.assertEquals(map.objectAt(new Vector2d(2,2))==a, true);
    }

}
