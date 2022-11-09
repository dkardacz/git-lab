package agh.ics.oop;

import java.util.List;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        System.out.println("system wystartował");

        MoveDirection[] directions = new OptionsParser().parse(args);


        //IWorldMap map = new RectangularMap(10, 5);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);

        engine.run();


        System.out.println("system zakończył działanie");
        //OptionsParser parser = new OptionsParser();
        //String[] dirs = args;
        //run1(dirs);
        //run2(dirs);
//        Vector2d position1 = new Vector2d(1,2);
//        System.out.println(position1);
//        Vector2d position2 = new Vector2d(-2,1);
//        System.out.println(position2);
//        System.out.println(position1.add(position2));
//
//        MapDirection[] mapdirs = {MapDirection.NORTH, MapDirection.EAST, MapDirection.SOUTH, MapDirection.WEST};
//
//        for (MapDirection dir: mapdirs) {
//            System.out.println(dir.toString());
//            System.out.println(dir.next());
//            System.out.println(dir.previous());
//            System.out.println(dir.toUnitVector());
//        }

        //Animal a1 = new Animal();
        //System.out.println(a1.toString());

//        MoveDirection[] movelist = {MoveDirection.RIGHT, MoveDirection.FORWARD, MoveDirection.FORWARD,MoveDirection.FORWARD};
//        for (MoveDirection move:movelist) {
//            a1.move(move);
//        }
//        System.out.println(a1.toString());
//
//        MoveDirection[] m = parser.parse(args);
//        for (MoveDirection move: m) {
//            System.out.println(move.toString());
//            a1.move(move);
//        }
//        System.out.println("Pozycja koncowa: ");
//        System.out.println(a1.toString());
    }

//    public static void run1(String[] directions) {
//        System.out.println("zwierzak idzie do przodu");
//        for (int i = 0; i < directions.length-1; i++) {
//            System.out.print(directions[i] +", ");
//        }
//        System.out.println(directions[directions.length-1]);
//    }
//    public static void run2(String[] directions) {
//        System.out.println("Start");
//        for (String dir : directions) {
//            for (char p : dir.toCharArray()) {
//                PrintDir(StrToDir(p));
//            }
//        }
//        System.out.println("Stop");
//    }
//    public static void PrintDir(Direction dir){
//        switch(dir){
//            case FORWARD:
//                System.out.println("zwierzak idzie do przodu");
//                break;
//            case BACKWARD:
//                System.out.println("zwierzak idzie do tyłu");
//                break;
//            case RIGHT:
//                System.out.println("zwierzak skręca w prawo");
//                break;
//            case LEFT:
//                System.out.println("zwierzak skręca w lewo");
//                break;
//        }
//    }
//    public static Direction StrToDir(char dir){
//            char f = 'f';
//            char b = 'b';
//            char r = 'r';
//            char l = 'l';
//
//            if(Character.compare(dir,f)==0) {return Direction.FORWARD;}
//            else if(Character.compare(dir,b)==0) {return Direction.BACKWARD;}
//            else if(Character.compare(dir,r)==0) {return Direction.RIGHT;}
//            else if(Character.compare(dir,l)==0) {return Direction.LEFT;}
//            else{return Direction.NULL;}
//    }
}

//Odpowiedz na punkt 10 w lab3 - mechanizm wykluczajacy pojawienie sie dwoch zwierzat w tym samym miejscu - sprawdzenie
//w konstruktorze czy dane miejsce jest wolne, jeśli nie, to pojscie w randomowym kierunku i ponowienie sprawdzenia
//(dopóki nie znajdzie sie miejsce, lub jeśli wszystkie miejsca sa zapelnione - te wartosc mozna przechowywac w osobnej zmiennej)
