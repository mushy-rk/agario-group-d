package com.example.oop_groupd_agario;

import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import com.example.oop_groupd_agario.HelloApplication;

public abstract class MenuApp extends HelloApplication{
    @Override
    protected void NEWMENU(Pane mainMenuRoot){
        Rectangle bg=new Rectangle(500,500);

        Button Start= new Button("PLAY AGARIO");


        Button Exit = new Button("EXIT AGARIO");

        VBox vbox =new VBox(50,Start,Exit);
        vbox.setTranslateX(250);
        vbox.setTranslateY(250);

        mainMenuRoot.getChildren().addAll(bg,vbox);
;
    }

    public static void main(String[] args) {
        launch(args);
    }










}
