package com.scully.models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Cell {

  private static final int WIDTH = 5;
  private static final int HEIGHT = 5;

  // Canvas data
  private int xPosition;
  private int yPosition;
  private GraphicsContext graphicsContext;

  // Relationship data
  private List<Cell> neighbours = new ArrayList<>();

  public Cell() {
  }

  public Cell(int xPosition, int yPosition, GraphicsContext graphicsContext,
      List<Cell> neighbours, boolean isAlive) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.graphicsContext = graphicsContext;
    this.neighbours = neighbours;
    this.isAlive = isAlive;
  }

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
    if (alive) {
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

  public void addNeighbour(Cell neighbour) {
    this.neighbours.add(neighbour);
  }

  // TODO
  public boolean canHaveNorthNeighbours(Canvas canvas) {
    return this.yPosition > HEIGHT;
  }

  // TODO
  public boolean canHaveSouthNeighbours(Canvas canvas) {
    return this.yPosition + HEIGHT < canvas.getHeight();
  }

  // TODO
  public boolean canHaveWestNeighbours(Canvas canvas) {
    return this.xPosition > WIDTH;
  }

  // TODO
  public boolean canHaveEastNeighbours(Canvas canvas) {
    return this.xPosition < canvas.getWidth();
  }
}
