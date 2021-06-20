package com.rgg.classicmodels.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/ClassicModelsView.fxml"));
        primaryStage.setTitle("Gestión de tienda ClassicModels");
        primaryStage.sizeToScene();
        primaryStage.getIcons().add(new Image("resources/car-icon.png"));
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}