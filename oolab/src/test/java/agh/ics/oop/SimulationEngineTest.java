package agh.ics.oop;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimulationEngineTest {

    @Test
    public void testRun(){
        String[] args = {"f", "b", "r", "l"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();

        Assertions.assertEquals(map.getAnimals().get(0).getPosition(), new Vector2d(2,3));
        Assertions.assertEquals(map.getAnimals().get(0).getOrientation(),MapDirection.EAST);
        Assertions.assertEquals(map.getAnimals().get(1).getPosition(), new Vector2d(3,3));
        Assertions.assertEquals(map.getAnimals().get(1).getOrientation(),MapDirection.WEST);
    }
}
