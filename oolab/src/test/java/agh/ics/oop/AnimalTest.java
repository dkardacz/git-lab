package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void testMove(){

        IWorldMap map = new RectangularMap(5, 5);
        Animal a = new Animal(map, new Vector2d(2,2));
        Animal b = new Animal(map, new Vector2d(3,4));
        MapDirection[] dirs1 = {MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST, MapDirection.NORTH};
        MapDirection[] dirs2 = {MapDirection.WEST, MapDirection.SOUTH, MapDirection.EAST, MapDirection.NORTH};

        for (int i = 0; i < 4; i++) {
            a.move(MoveDirection.LEFT);
            b.move(MoveDirection.RIGHT);
            Assertions.assertEquals(a.getOrientation(), dirs2[i]);
            Assertions.assertEquals(b.getOrientation(), dirs1[i]);
        }

        Animal c = new Animal(map, new Vector2d(2,2));
        Animal d = new Animal(map, new Vector2d(3,4));

        for (int i = 0; i < 10; i++) {
            c.move(MoveDirection.FORWARD);
            d.move(MoveDirection.BACKWARD);
        }
        c.move(MoveDirection.RIGHT);
        d.move(MoveDirection.RIGHT);
        for (int i = 0; i < 10; i++) {
            c.move(MoveDirection.FORWARD);
            d.move(MoveDirection.BACKWARD);
        }
        Assertions.assertEquals(c.getPosition(), new Vector2d(5,5));
        Assertions.assertEquals(d.getPosition(), new Vector2d(0,0));
    }

}
