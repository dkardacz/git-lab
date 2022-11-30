package agh.ics.oop;

public class OptionsParser {

    public MoveDirection[] parse(String[] args){

        MoveDirection[] results = new MoveDirection[args.length];
        int i = 0;
        int counter = 0;
        for(String dir:args) {
            if (dir.equals("f") || dir.equals("forward")) {
                results[i] = MoveDirection.FORWARD;
            } else if (dir.equals("b") || dir.equals("backward")) {
                results[i] = MoveDirection.BACKWARD;
            } else if (dir.equals("r") || dir.equals("right")) {
                results[i] = MoveDirection.RIGHT;
            } else if (dir.equals("l") || dir.equals("left")) {
                results[i] = MoveDirection.LEFT;
            } else {
                results[i] = null;
                counter = counter + 1;
                throw new IllegalArgumentException(dir + " is an invalid argument");
            }

            i = i+1;
        }
        MoveDirection[] results2 = new MoveDirection[args.length-counter];
        int j = 0;
        for (MoveDirection move:results) {
            if(move!=null){
                results2[j] = move;
                j=j+1;
            }
        }
        return results2;
    }
}
