package com.example.oop_groupd_agario;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {


        Group myGroup = new Group();

        // bg
        Rectangle rect = new Rectangle(2000, 1280, Paint.valueOf("#88b6db"));
        myGroup.getChildren().add(rect);

        // text
        Label label = new Label("WELCOME TO AGARIO");
        label.setScaleY(10);
        label.setScaleX(10);
        label.setLayoutX(900);
        label.setLayoutY(150);
        label.setTextFill(Color.WHITE);
        myGroup.getChildren().add(label);

        // PLAY button
        Rectangle button = new Rectangle(400, 100, Paint.valueOf("#ffffff"));
        button.setX(750);
        button.setY(400);
        myGroup.getChildren().add(button);

        // PLAY text
        Label text = new Label("PLAY AGARIO");
        text.setScaleY(3);
        text.setScaleX(3);
        text.setLayoutX(900);
        text.setLayoutY(450);
        text.setTextFill(Color.PINK);
        myGroup.getChildren().add(text);

        // press button(PLAY)
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    // launch game
                    new HelloApplication().start(new Stage());
                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);



        //CUSTOMISATION BUTTON
        Rectangle button2 = new Rectangle(400, 100, Paint.valueOf("#ffffff"));
        button2.setX(750);
        button2.setY(550);
        myGroup.getChildren().add(button2);

        //CUSTOMISATION TEXT
        Label text2 = new Label("CUSTOMISATION");
        text2.setScaleY(3);
        text2.setScaleX(3);
        text2.setLayoutX(900);
        text2.setLayoutY(600);
        text2.setTextFill(Color.PINK);
        myGroup.getChildren().add(text2);

        //CUSTOMISATION CLICK BUTTON
        EventHandler<MouseEvent> handler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event2) {
                try {
                    // launch game
                    new Customisation().start(new Stage());

                    stage.close();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        };
        button2.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);

        Scene scene = new Scene(myGroup, 1280, 720);
        stage.setTitle("Agar.io");
        stage.setScene(scene);
        stage.show();



    }
    public static void main(String[] args) {
        launch();
    }
}



