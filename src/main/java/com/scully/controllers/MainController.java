package com.scully.controllers;

import com.scully.Main;
import com.scully.models.Cell;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MainController implements Initializable {

  // FXML variables
  @FXML
  private Canvas canvas;


  // Custom variables
  private int[] rows;
  private int[] columns;

  private List<Cell> cells;


  public MainController() {
    log.info("Main Controller constructor...");
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    canvas.setHeight(Main.STAGE_HEIGHT);
    canvas.setWidth(Main.STAGE_WIDTH);
    rows = new int[(int) canvas.getHeight() / Cell.getHeight()];
    columns = new int[(int) canvas.getWidth() / Cell.getWidth()];


    log.info("rows : {}", rows.length);
    log.info("columns : {}", columns.length);

    // Cell creating loop
    cells = new ArrayList<>();
    for (int i = 0; i < rows.length; i++) {

      for (int j = 0; j < columns.length; j++) {
        Cell cell = new Cell();
        cell.setXPosition(i);
        cell.setYPosition(j);
        cells.add(cell);
      }
    }

    GraphicsContext graphicsContext2D = canvas.getGraphicsContext2D();
    cells.forEach(cell -> {
      log.info("X: {} | Y: {}", cell.getXPosition(), cell.getYPosition());
      graphicsContext2D.setFill(Color.WHITE);
      graphicsContext2D.fillRect(cell.getXPosition(), cell.getYPosition(), Cell.getWidth(), Cell.getHeight());

    });


  }
}
