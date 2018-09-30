package com.scully.models;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cell {

  private static final int WIDTH = 5;
  private static final int HEIGHT = 5;

  private int xPosition;
  private int yPosition;
  private GraphicsContext graphicsContext;

  private boolean isAlive = false;

  public int getXPosition() {
    return xPosition;
  }

  public void setXPosition(int xPosition) {
    this.xPosition = xPosition;
  }

  public int getYPosition() {
    return yPosition;
  }

  public void setYPosition(int yPosition) {
    this.yPosition = yPosition;
  }

  public static int getWidth() {
    return WIDTH;
  }

  public static int getHeight() {
    return HEIGHT;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public Cell setAlive(boolean alive) {
    isAlive = alive;
    if (alive){
      graphicsContext.setFill(Color.WHITE);
    } else {
      graphicsContext.setFill(Color.BLACK);
    }
    graphicsContext.fillRect(this.getXPosition(), this.getYPosition(), WIDTH, HEIGHT);
    return this;
  }

  public void setGraphicsContext(GraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
  }
}
