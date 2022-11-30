package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;

import java.util.List;
import java.util.Map;

public class World {
    public static void main(String[] args) {
        try {
            System.out.println("system wystartował");
            Application.launch(App.class, args);
            System.out.println("system zakończył działanie");
        }
        catch (IllegalArgumentException ex){
            System.out.println(ex);
           // System.exit(0);
        }
    }
}