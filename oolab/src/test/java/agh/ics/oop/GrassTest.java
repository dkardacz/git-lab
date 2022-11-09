package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrassTest {

    @Test
    public void testGetPosition(){
        Grass g1 = new Grass(new Vector2d(2,2));
        Grass g2 = new Grass(new Vector2d(3,4));

        Assertions.assertTrue(g1.getPosition().equals(new Vector2d(2,2)));
        Assertions.assertTrue(g2.getPosition().equals(new Vector2d(3,4)));
        Assertions.assertFalse(g2.getPosition().equals(new Vector2d(2,2)));
    }
}
