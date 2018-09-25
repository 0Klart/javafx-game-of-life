package com.scully.models;

public class Cell {

  private static final int width = 2;
  private static final int height = 2;

  private int xPosition;
  private int yPosition;

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
    return width;
  }

  public static int getHeight() {
    return height;
  }

  public boolean isAlive() {
    return isAlive;
  }

  public void setAlive(boolean alive) {
    isAlive = alive;
  }
}
