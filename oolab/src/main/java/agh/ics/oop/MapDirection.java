package agh.ics.oop;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    EAST,
    WEST;

    public String toString() {
        String x = switch (this){
            case NORTH -> "Północ";
            case SOUTH -> "Południe";
            case WEST -> "Zachód";
            case EAST -> "Wschód";
        };
        return x;
    }

    public MapDirection next(){
        MapDirection x = switch (this){
            case NORTH -> EAST;
            case EAST -> SOUTH;
            case SOUTH -> WEST;
            case WEST -> NORTH;
        };
        return x;
    }

    public MapDirection previous(){
        MapDirection x = switch (this){
            case NORTH -> WEST;
            case EAST -> NORTH;
            case SOUTH -> EAST;
            case WEST -> SOUTH;
        };
        return x;
    }

    public Vector2d toUnitVector(){
        Vector2d x = switch (this){
            case NORTH -> new Vector2d(0,1);
            case EAST -> new Vector2d(1,0);
            case SOUTH -> new Vector2d(0,-1);
            case WEST -> new Vector2d(-1,0);
        };
        return x;
    }
}

