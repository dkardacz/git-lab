package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Vector;

public class Vector2dTest {
    @Test
    public void testEquals(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,1);
        Vector2d c = new Vector2d(1,2);
        Vector2d d = new Vector2d(-2,1);

        Assertions.assertEquals(a,a);
        Assertions.assertEquals(b,b);
        Assertions.assertEquals(c,c);
        Assertions.assertEquals(d,d);
        Assertions.assertEquals(a,c);
        Assertions.assertEquals(c,a);
        Assertions.assertEquals(b,d);
        Assertions.assertEquals(d,b);
    }

    @Test
    public void testToString(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,1);
        String astring = new String("(1,2)");
        String bstring = new String("(-2,1)");

        Assertions.assertEquals(a.toString(),astring);
        Assertions.assertEquals(b.toString(),bstring);
    }

    @Test
    public void testPrecedes(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,1);
        Vector2d c = new Vector2d(5,5);

        Assertions.assertEquals(a.precedes(b),false);
        Assertions.assertEquals(a.precedes(c),true);
    }

    @Test
    public void testFollows(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,1);
        Vector2d c = new Vector2d(5,5);

        Assertions.assertEquals(a.follows(b),true);
        Assertions.assertEquals(a.follows(c),false);
    }

    @Test
    public void testUpperRight(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,3);
        Vector2d c = new Vector2d(1,3);

        Assertions.assertEquals(a.upperRight(b),c);
        Assertions.assertEquals(b.upperRight(a),c);
    }

    @Test
    public void testLowerLeft(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,3);
        Vector2d c = new Vector2d(-2,2);

        Assertions.assertEquals(a.lowerLeft(b),c);
        Assertions.assertEquals(b.lowerLeft(a),c);
    }

    @Test
    public void testAdd(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,3);
        Vector2d c = new Vector2d(-1,5);
        Vector2d d = new Vector2d(0,7);

        Assertions.assertEquals(a.add(b),c);
        Assertions.assertEquals(b.add(a),c);
        Assertions.assertEquals(a.add(c),d);
        Assertions.assertEquals(c.add(a),d);
    }

    @Test
    public void testSubtract(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,3);
        Vector2d c = new Vector2d(3,-1);
        Vector2d d = new Vector2d(-2,1);

        Assertions.assertEquals(a.subtract(b),c);
        Assertions.assertEquals(a.subtract(c),b);
    }

    @Test
    public void testOpposite(){
        Vector2d a = new Vector2d(1,2);
        Vector2d b = new Vector2d(-2,3);
        Vector2d c = new Vector2d(-1,-2);
        Vector2d d = new Vector2d(2,-3);

         Assertions.assertEquals(a.opposite(), c);
         Assertions.assertEquals(b.opposite(), d);
         Assertions.assertEquals(c.opposite(), a);
         Assertions.assertEquals(d.opposite(), b);
    }
}
