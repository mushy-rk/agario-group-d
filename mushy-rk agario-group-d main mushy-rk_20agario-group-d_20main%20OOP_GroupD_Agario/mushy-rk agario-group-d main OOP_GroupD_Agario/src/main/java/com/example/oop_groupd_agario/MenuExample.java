package com.example.oop_groupd_agario;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuExample extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group myGroup = new Group();

        //background
        Rectangle rect = new Rectangle(1280,1280, Paint.valueOf("#88b6db"));
        myGroup.getChildren().add(rect);

        //text
        Label label = new Label("WELCOME TO AGARIO");
        label.setScaleY(10);
        label.setScaleX(10);
        label.setLayoutX(610);
        label.setLayoutY(150);
        label.setTextFill(Color.WHITE);
        myGroup.getChildren().add(label);


        //button
        Rectangle button = new Rectangle(400,100, Paint.valueOf("#ffffff"));
        button.setX(450);
        button.setY(400);
        myGroup.getChildren().add(button);

        //start text
        Label text = new Label("PLAY AGARIO");
        text.setScaleY(5);
        text.setScaleX(5);
        text.setLayoutX(620);
        text.setLayoutY(460);
        text.setTextFill(Color.PINK);
        myGroup.getChildren().add(text);

        //button press
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent event) {



            }
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED,handler);

        Scene scene = new Scene(myGroup, 1280, 720);
        stage.setTitle("Agar.io");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}



