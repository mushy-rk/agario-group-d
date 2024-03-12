package com.example.oop_groupd_agario;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HelloApplication extends Application {
    private static final double velo = 0.01; // velocity of circle
    private static final int irad = 50; // initial radius of circle
    private static final int SpawnCool = 1; // cooldown between spawn attempts in seconds

    private double mouseX;
    private double mouseY;
    private long lastSpawnTime;

    private Circle circle;
    private List<Circle> food;

    @Override
    public void start(Stage stage) {
        Group root = new Group();
        Scene scene = new Scene(root, 1000, 1000, Color.WHITE);
        stage.setTitle("Welcome to AGARIO");
        stage.setScene(scene);
        stage.show();

        circle = new Circle(250, 250, irad, Color.PINK);
        root.getChildren().add(circle);

        food = new ArrayList<>();

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

                // calculates movement
                double moveX = dx * velo;
                double moveY = dy * velo;

                // updates circle position
                circle.setCenterX(circle.getCenterX() - moveX);
                circle.setCenterY(circle.getCenterY() - moveY);

                // check for collisions with food
                for (Circle ball : food) {
                    if (circle.getBoundsInParent().intersects(ball.getBoundsInParent())) {
                        // if collision, remove food and increase the radius of the circle
                        food.remove(ball);
                        root.getChildren().remove(ball);
                        circle.setRadius(circle.getRadius() + 2); // increase circle size
                        break;
                    }
                }

                // spawn food based on cooldown
                if (System.currentTimeMillis() - lastSpawnTime > SpawnCool * 300) {
                    spawnBalls(root);
                    lastSpawnTime = System.currentTimeMillis();
                }
            }
        }.start();
    }

    // spawn balls of mass randomly on the map with random colors
    private void spawnBalls(Group root) {
        Random rand = new Random();
        if (food.size() < 100) {
            double x = rand.nextDouble() * 1000; // random x cord
            double y = rand.nextDouble() * 1000; // random y cord
            Color randomColor = Color.rgb(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)); // random colour
            Circle ball = new Circle(x, y, 5, randomColor); // food radius
            food.add(ball);
            root.getChildren().add(ball);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
