package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RectangularMapTest {

    @Test
    public void testIsOccupied(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal a = new Animal(map, new Vector2d(2,2));
        map.place(a);

        Assertions.assertTrue(map.isOccupied(new Vector2d(2,2)));
        Assertions.assertFalse(map.isOccupied(new Vector2d(3,4)));
    }

    @Test
    public void testCanMoveTo(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal a = new Animal(map, new Vector2d(2,2));
        map.place(a);

        Assertions.assertTrue(map.canMoveTo(new Vector2d(2,3)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(2,2)));
        Assertions.assertFalse(map.canMoveTo(new Vector2d(11,11)));
    }

    @Test
    public void testPlace(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal a = new Animal(map, new Vector2d(2,2));
        Assertions.assertTrue(map.place(a));

        Animal b = new Animal(map,new Vector2d(2,2));
        Assertions.assertFalse(map.place(b));
    }
    
    @Test
    public void testObjectAt(){
        IWorldMap map = new RectangularMap(10, 5);
        Animal a = new Animal(map, new Vector2d(2,2));
        map.place(a);
        
        Assertions.assertEquals(map.objectAt(new Vector2d(2,2))==a, true);
    }

}
