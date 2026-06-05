package com.slimene.examen_2024;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("enseignants.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
