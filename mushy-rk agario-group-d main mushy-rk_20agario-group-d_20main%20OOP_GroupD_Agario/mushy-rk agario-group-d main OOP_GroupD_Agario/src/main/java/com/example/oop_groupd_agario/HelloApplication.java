package com.example.oop_groupd_agario;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        Group myGroup= new Group();
        Scene MyScene=new Scene(myGroup,500,500,Paint.valueOf("white"));
        stage.setTitle("Welcome to AGARIO");
        stage.setScene(MyScene);
        stage.show();
        Circle myCircle= new Circle(50, Paint.valueOf("pink"));
        myGroup.getChildren().add(myCircle);
        myCircle.setCenterX(250);
        myCircle.setCenterY(250);



    }



    public static void main(String[] args) {
        launch(args);
    }









}