package com.example.oop_groupd_agario;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.IOException;

public class  HelloApplication extends Application {

    private static final double SPEED = 0.01; // speed of circle
    private double mouseX;
    private double mouseY;
    Circle circle = new Circle(250, 250, 50, Color.PINK);
    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, 500, 500, Color.WHITE);
        stage.setTitle("Welcome to AGARIO");
        stage.setScene(scene);
        stage.show();

        Circle circle = new Circle(250, 250, 50, Color.PINK);
        root.getChildren().add(circle);

        // track mouse movement
        scene.setOnMouseMoved(event -> {
            mouseX = event.getX();
            mouseY = event.getY();


        });

        // circle moves gradually to pointer
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // distance between circle position and pointer
                double dx = circle.getCenterX() - mouseX;
                double dy = circle.getCenterY() - mouseY;

                // calculates movenment
                double moveX = dx * SPEED;
                double moveY = dy * SPEED;

                // updates circle position
                circle.setCenterX(circle.getCenterX() - moveX);
                circle.setCenterY(circle.getCenterY() - moveY);
            }
        }.start();


        //Food
        Circle food=new Circle(20,20,20,Color.LAWNGREEN);
        food.setLayoutY(Math.random()*500);
        food.setLayoutX(Math.random()*1000);
        root.getChildren().add(food);

        //ScoreBoard
        System.out.println("ENTER NAME");
        Label score= new Label("SCOREBOARD:");//Add mass here (whoever is in charge of that:))
        score.setScaleX(3);
        score.setScaleY(3);
        score.setLayoutY(30);
        score.setLayoutX(150);
        score.setTextFill(Color.BLACK);
        root.getChildren().add(score);

    }





    public static void main(String[] args) {
        launch();
    }
}









