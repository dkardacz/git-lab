package agh.ics.oop;

import java.util.List;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");
        //String[] dirs = args;
        //run1(dirs);
        //run2(dirs);
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));

        MapDirection[] mapdirs = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};

        for (MapDirection dir: mapdirs) {
            System.out.println(dir.toString());
            System.out.println(dir.next());
            System.out.println(dir.previous());
            System.out.println(dir.toUnitVector());
        }

        System.out.println("system zakończył działanie");
    }

    public static void run1(String[] directions) {
        System.out.println("zwierzak idzie do przodu");
        for (int i = 0; i < directions.length-1; i++) {
            System.out.print(directions[i] +", ");
        }
        System.out.println(directions[directions.length-1]);
    }
    public static void run2(String[] directions) {
        System.out.println("Start");
        for (String dir : directions) {
            for (char p : dir.toCharArray()) {
                PrintDir(StrToDir(p));
            }
        }
        System.out.println("Stop");
    }
    public static void PrintDir(Direction dir){
        switch(dir){
            case FORWARD:
                System.out.println("zwierzak idzie do przodu");
                break;
            case BACKWARD:
                System.out.println("zwierzak idzie do tyłu");
                break;
            case RIGHT:
                System.out.println("zwierzak skręca w prawo");
                break;
            case LEFT:
                System.out.println("zwierzak skręca w lewo");
                break;
        }
    }
    public static Direction StrToDir(char dir){
            char f = 'f';
            char b = 'b';
            char r = 'r';
            char l = 'l';

            if(Character.compare(dir,f)==0) {return Direction.FORWARD;}
            else if(Character.compare(dir,b)==0) {return Direction.BACKWARD;}
            else if(Character.compare(dir,r)==0) {return Direction.RIGHT;}
            else if(Character.compare(dir,l)==0) {return Direction.LEFT;}
            else{return Direction.NULL;}
    }
}
