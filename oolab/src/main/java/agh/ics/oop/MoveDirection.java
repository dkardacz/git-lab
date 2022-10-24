package agh.ics.oop;

public enum MoveDirection {
    FORWARD,
    BACKWARD,
    RIGHT,
    LEFT;

    public String toString(){
        String res = switch(this){
            case FORWARD -> "Forward";
            case RIGHT -> "Right";
            case BACKWARD -> "Backward";
            case LEFT -> "Left";
            default -> "cos nie tak";
        };
        return res;
    }
}
