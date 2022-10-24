package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OptionsParserTest {
    @Test
    public void testParse(){
        OptionsParser parser = new OptionsParser();
        String[] movestring = {"f", "forward", "a", "c", "right", "niewiem", "l", "left"};
        MoveDirection[] moves = {MoveDirection.FORWARD, MoveDirection.FORWARD, MoveDirection.RIGHT, MoveDirection.LEFT, MoveDirection.LEFT};
        MoveDirection[] moves2 = parser.parse(movestring);
        for (int i = 0; i < moves.length; i++) {
            Assertions.assertEquals(moves[i],moves2[i]);
        }
    }
}
