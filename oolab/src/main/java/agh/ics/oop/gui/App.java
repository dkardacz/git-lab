package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import static java.lang.Math.abs;

public class App extends Application {

    IWorldMap map;
    Vector2d upperRight;
    Vector2d lowerLeft;

    public void start(Stage primaryStage){
        String [] args = getParameters().getRaw().toArray(new String[0]);
        for (String a :
                args){
            System.out.println(a);
        }
        MoveDirection[] directions = new OptionsParser().parse(args);
        IWorldMap map = new GrassField(10);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();


        upperRight = map.getMapBoundry().getUpperRight();
        lowerLeft = map.getMapBoundry().getLowerLeft();

        int x0 = lowerLeft.x;
        int x1 = upperRight.x;
        int y0 = lowerLeft.y;
        int y1 = upperRight.y;

        int xdiff = abs(x1 - x0) + 1;
        int ydiff = abs(y1 - y0) + 1;

        System.out.println("UpRight: " + upperRight.toString());
        System.out.println("LowLeft: " + lowerLeft.toString());

        Label label = new Label("y/x");
        GridPane gridPane = new GridPane();
        gridPane.add(label, 0, 0, 1, 1);


        int xi = x0-1;
        int yi = y1+1;
        for (int i = 0; i <= ydiff; i++) {
            xi = x0-1;
            for(int j = 0; j<= xdiff; j++){
                if(i==0 && j>0){
                    Label x = new Label(Integer.toString(xi));
                    gridPane.add(x,j,0,1,1);
                }
                else if(j==0 && i>0){
                    Label y = new Label(Integer.toString(yi));
                    gridPane.add(y,0,i,1,1);
                }
                else{
                    if(map.objectAt(new Vector2d(xi,yi)) != null) {
                        Label g = new Label(map.objectAt(new Vector2d(xi, yi)).toString());
                        gridPane.add(g, j, i, 1, 1);
                    }
                }
                xi+=1;
            }
            yi-=1;
        }

        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(20));
        gridPane.getRowConstraints().add(new RowConstraints(20));
        GridPane.setHalignment(label, HPos.CENTER);

        Scene scene = new Scene(gridPane, 400, 400);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
