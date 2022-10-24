package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    @Test
    public void testMove(){
        Animal a = new Animal();
        Animal b = new Animal();
        MapDirection[] dirs1 = {MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST, MapDirection.NORTH};
        MapDirection[] dirs2 = {MapDirection.WEST, MapDirection.SOUTH, MapDirection.EAST, MapDirection.NORTH};

        for (int i = 0; i < 4; i++) {
            a.move(MoveDirection.LEFT);
            b.move(MoveDirection.RIGHT);
            Assertions.assertEquals(a.getOrientation(), dirs2[i]);
            Assertions.assertEquals(b.getOrientation(), dirs1[i]);
        }

        Animal c = new Animal();
        Animal d = new Animal();

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
        Assertions.assertEquals(c.getPosition(), new Vector2d(4,4));
        Assertions.assertEquals(d.getPosition(), new Vector2d(0,0));
    }

}
