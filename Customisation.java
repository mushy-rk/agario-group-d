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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class Customisation extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Group myGroup = new Group();

        // bg
        Rectangle rect = new Rectangle(2000, 1280, Paint.valueOf("#88b6db"));
        myGroup.getChildren().add(rect);

        // text
        Label label = new Label("CUSTOMISATION MENU");
        label.setScaleY(10);
        label.setScaleX(10);
        label.setLayoutX(900);
        label.setLayoutY(150);
        label.setTextFill(Color.WHITE);
        myGroup.getChildren().add(label);

        // PINK button
        Rectangle button = new Rectangle(400, 100, Paint.valueOf("#ffffff"));
        button.setX(750);
        button.setY(400);
        myGroup.getChildren().add(button);

        // PINK text
        Label text = new Label("PINK(Default)");
        text.setScaleY(3);
        text.setScaleX(3);
        text.setLayoutX(900);
        text.setLayoutY(450);
        text.setTextFill(Color.PINK);
        myGroup.getChildren().add(text);

        // press button(PINK)
        EventHandler<MouseEvent> handler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    // launch game
                    new HelloApplication().start(new Stage());
                    String spritecolour = "PINK";

                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };
        button.addEventFilter(MouseEvent.MOUSE_CLICKED, handler);

        Scene scene = new Scene(myGroup, 1280, 720);
        stage.setTitle("Agar.io");
        stage.setScene(scene);
        stage.show();


        // RED button
        Rectangle button2 = new Rectangle(400, 100, Paint.valueOf("#ffffff"));
        button2.setX(750);
        button2.setY(550);
        myGroup.getChildren().add(button2);

        // RED text
        Label text2 = new Label("RED");
        text2.setScaleY(3);
        text2.setScaleX(3);
        text2.setLayoutX(850);
        text2.setLayoutY(600);
        text2.setTextFill(Color.RED);
        myGroup.getChildren().add(text2);

        // press button(RED)
        EventHandler<MouseEvent> handler2 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    // launch game
                    new HelloApplication().start(new Stage());
                    String spritecolour = "RED";

                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        button2.addEventFilter(MouseEvent.MOUSE_CLICKED, handler2);

        // BLUE button
        Rectangle button3 = new Rectangle(400, 100, Paint.valueOf("#ffffff"));
        button3.setX(750);
        button3.setY(700);
        myGroup.getChildren().add(button3);

        // BLUE text
        Label text3 = new Label("BLUE");
        text3.setScaleY(3);
        text3.setScaleX(3);
        text3.setLayoutX(850);
        text3.setLayoutY(750);
        text3.setTextFill(Color.LIGHTSKYBLUE);
        myGroup.getChildren().add(text3);

        // press button(BLUE)
        EventHandler<MouseEvent> handler3 = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                try {
                    // launch game
                    new HelloApplication().start(new Stage());
                    String spritecolour = "BLUE";

                    stage.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };
        button3.addEventFilter(MouseEvent.MOUSE_CLICKED, handler3);



    }
    public static void main(String[] args) {
        launch();
    }
}