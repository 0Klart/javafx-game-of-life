package com.scully;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

  public static final Integer STAGE_WIDTH = 400;
  public static final Integer STAGE_HEIGHT = 400;

  @Override
  public void start(Stage primaryStage) throws Exception {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/main.fxml"));
    primaryStage.setTitle("JavaFX Conway's Game of Life - created by David Scully");
    primaryStage.setScene(new Scene(root, STAGE_WIDTH, STAGE_HEIGHT));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
