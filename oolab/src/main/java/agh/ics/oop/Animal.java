package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    private IWorldMap map;

    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        this.position = initialPosition;
    }

    public String toString(){
        //String res = new String(position.toString() +", "+orientation.toString());
        String res = switch(orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
        return res;
    }

    public boolean isAt(Vector2d position){
        if(this.position.equals(position)){
            return true;
        }
        else{
            return false;
        }
    }

    public void move(MoveDirection dir){
        switch (dir){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> {
                if(map.canMoveTo(position.add(orientation.toUnitVector()))){
                        position = position.add(orientation.toUnitVector());
                        }
            }
            case BACKWARD -> {
                if(map.canMoveTo(position.subtract(orientation.toUnitVector()))){
                    position = position.subtract(orientation.toUnitVector());
                }
            }
        }
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){
        return position;
    }

}
