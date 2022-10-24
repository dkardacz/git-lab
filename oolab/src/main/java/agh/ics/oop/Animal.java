package agh.ics.oop;

public class Animal {
    private Vector2d position = new Vector2d(2,2);
    private MapDirection orientation = MapDirection.NORTH;

    public String toString(){
        String res = new String(position.toString() +", "+orientation.toString());
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
        Vector2d original = position;
        switch (dir){
            case LEFT -> orientation = orientation.previous();
            case RIGHT -> orientation = orientation.next();
            case FORWARD -> position = position.add(orientation.toUnitVector());
            case BACKWARD -> position = position.subtract(orientation.toUnitVector());
        }
        if(position.x > 4 || position.y > 4 || position.x < 0 || position.y<0){
            position = original;
        }
    }

    public MapDirection getOrientation(){
        return orientation;
    }

    public Vector2d getPosition(){
        return position;
    }

}
