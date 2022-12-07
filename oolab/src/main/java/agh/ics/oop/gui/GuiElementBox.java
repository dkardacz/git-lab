package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class GuiElementBox{

    VBox box;
    public GuiElementBox(IMapElement el){
        try{

            Image image = new Image(new FileInputStream(el.getTextureURL()));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label text = new Label(el.getPosition().toString());
            box = new VBox(imageView,text);
            box.setAlignment(Pos.CENTER);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public VBox getBox(){return box;}

}
