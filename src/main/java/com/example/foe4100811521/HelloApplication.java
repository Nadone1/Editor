package com.example.foe4100811521;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("login.fxml"));
Image login = new Image(getClass().getResourceAsStream("icons.png"));
stage.getIcons().add(login);
        Scene scene = new Scene(fxmlLoader.load(), 569, 388);
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
        //Donkor Nana Acamoah
        //FOE.41.008.115.21
    }

    public static void main(String[] args) {
        launch();
    }
}