package com.example.webcrawlermvc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class WebCrawlerApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(WebCrawlerApplication.class.getResource("view/WebCrawlerView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600.0, 847.0);
        stage.setTitle("Welcome to the webcrawler!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}