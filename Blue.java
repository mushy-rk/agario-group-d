package com.example.oop_groupd_agario;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Blue extends Application {
    private static final int WIDTH = 2500;
    private static final int HEIGHT = 1000;
    private static final int PLAYER_RADIUS = 50;
    private static final int FOOD_RADIUS = 10;
    private static final int INITIAL_FOOD_COUNT = 200;
    private static final double PLAYER_INITIAL_SPEED = 2.0;

    private Player player;
    private List<Food> foodList;

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(WIDTH, HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        // Initialize game objects
        player = new Player(WIDTH / 2, HEIGHT / 2,  PLAYER_RADIUS, Color.SKYBLUE, PLAYER_INITIAL_SPEED);
        foodList = new ArrayList<>();
        spawnFood(INITIAL_FOOD_COUNT);

        // Game loop
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Update and render game objects
                update();
                render(gc);
            }
        }.start();

        // Mouse event handler for player movement
        canvas.setOnMouseMoved(event -> {
            player.setTargetX(event.getX());
            player.setTargetY(event.getY());
        });

        StackPane root = new StackPane();
        root.getChildren().add(canvas);

        primaryStage.setScene(new Scene(root, WIDTH, HEIGHT));
        primaryStage.setTitle("Agar.io Clone");
        primaryStage.show();
    }

    private void update() {
        // Move player
        player.move();

        // Check for collision between player and food, and handle growth and speed decrease
        foodList.removeIf(food -> {
            if (player.intersects(food)) {
                player.grow();
                return true;
            }
            return false;
        });

        // Respawn food if necessary
        if (foodList.size() < INITIAL_FOOD_COUNT) {
            spawnFood(INITIAL_FOOD_COUNT - foodList.size());
        }
    }

    private void render(GraphicsContext gc) {
        // Clear canvas
        gc.clearRect(0, 0, WIDTH, HEIGHT);

        // Render player
        player.render(gc);

        // Render food
        for (Food food : foodList) {
            food.render(gc);
        }
    }

    private void spawnFood(int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            double x = random.nextDouble() * WIDTH;
            double y = random.nextDouble() * HEIGHT;
            Color color = Color.GREEN;
            foodList.add(new Food(x, y, FOOD_RADIUS, color));
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    private static class Player {
        private double x, y, targetX, targetY;
        private int radius;
        private Color color;
        private double speed; // Speed attribute

        public Player(double x, double y, int radius, Color color, double speed) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = color;
            this.speed = speed;
            this.targetX = x;
            this.targetY = y;
        }

        public void setTargetX(double targetX) {
            this.targetX = targetX;
        }

        public void setTargetY(double targetY) {
            this.targetY = targetY;
        }

        public void move() {
            double dx = targetX - x;
            double dy = targetY - y;
            double distance = Math.sqrt(dx * dx + dy * dy);
            if (distance > 0) {
                double factor = Math.min(speed, distance) / distance;
                x += dx * factor;
                y += dy * factor;
            }
        }

        public void render(GraphicsContext gc) {
            gc.setFill(color);
            gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }

        public boolean intersects(Food food) {
            double dx = x - food.getX();
            double dy = y - food.getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
            return distance < radius + food.getRadius();
        }

        public void grow() {
            this.radius += 1; // Increase the radius by a fixed amount
            System.out.println(radius);
            this.speed *= 0.995 ; // Decrease speed but prevent it from going below 1
        }
    }

    private static class Food {
        private double x, y;
        private int radius;
        private Color color;

        public Food(double x, double y, int radius, Color color) {
            this.x = x;
            this.y = y;
            this.radius = radius;
            this.color = generateRandomColor();
        }

        private Color generateRandomColor() {
            Random random = new Random();
            // Generate random RGB values
            double red = random.nextDouble();
            double green = random.nextDouble();
            double blue = random.nextDouble();
            return new Color(red, green, blue, 1.0); // Opaque color
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public int getRadius() {
            return radius;
        }

        public void render(GraphicsContext gc) {
            gc.setFill(color);
            gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        }
    }
}








