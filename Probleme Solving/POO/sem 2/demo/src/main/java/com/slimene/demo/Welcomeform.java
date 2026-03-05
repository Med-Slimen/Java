package com.slimene.demo;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Welcomeform extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Welcome to JavaFX !");
        primaryStage.show();
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Scene scene = new Scene(grid, 320, 240);
        primaryStage.setScene(scene);
        Text sceneTitle = new Text("Welcome to JavaFX !");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
        grid.add(sceneTitle, 0, 0, 2, 1);
        Label username= new Label("User Name");
        grid.add(username, 0, 1);
        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        Label password= new Label("Password");
        grid.add(password, 0, 2);
        PasswordField passwordTextField = new PasswordField();
        grid.add(passwordTextField, 1, 2);
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);
        final Text actiontarget = new Text();

        grid.add(actiontarget, 1, 6);
        String passwordTest="slimene123";
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                if(passwordTextField.getText().equals(passwordTest)){
                    actiontarget.setFill(Color.GREEN);
                    actiontarget.setText("Password Correct! !");
                }
                else{
                    actiontarget.setFill(Color.FIREBRICK);
                    actiontarget.setText("Password Wrong! !");
                }
            }
        });
        Button exitBtn=new  Button("Exit");
        grid.add(exitBtn, 1, 5);
        exitBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });


    }
}
