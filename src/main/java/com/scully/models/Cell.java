package com.scully.models;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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

  public Cell(int xPosition, int yPosition, GraphicsContext graphicsContext) {
    this.xPosition = xPosition;
    this.yPosition = yPosition;
    this.graphicsContext = graphicsContext;
  }

  public void setNeighbours() {
    // North neighbours
    if (this.canHaveNorthNeighbours()) {
      // North
      Cell northNeighbour = new Cell();
      northNeighbour.setXPosition(xPosition);
      northNeighbour.setYPosition(yPosition - 1);
      log.info("Adding north neighbour");
      this.addNeighbour(northNeighbour);

      // North west
      if (this.canHaveWestNeighbours()) {
        Cell northWestNeighbour = new Cell();
        northWestNeighbour.setXPosition(xPosition - 1);
        northWestNeighbour.setYPosition(yPosition - 1);
        log.info("Adding north-west neighbour");
        this.addNeighbour(northWestNeighbour);
      }
      // North east
      if (this.canHaveEastNeighbours()) {
        Cell northEastNeighbour = new Cell();
        northEastNeighbour.setXPosition(xPosition + 1);
        northEastNeighbour.setYPosition(yPosition - 1);
        log.info("Adding north-east neighbour");
        this.addNeighbour(northEastNeighbour);
      }
    }
    // West neighbours
    if (this.canHaveWestNeighbours()) {
      Cell west = new Cell();
      west.setXPosition(xPosition - 1);
      west.setYPosition(yPosition);
      log.info("Adding west neighbour");
      this.addNeighbour(west);
    }
    // East neighbours
    if (this.canHaveEastNeighbours()) {
      Cell east = new Cell();
      east.setXPosition(xPosition + 1);
      east.setYPosition(yPosition);
      log.info("Adding east neighbour");
      this.addNeighbour(east);
    }
    // South neighbours
    if (this.canHaveSouthNeighbours()) {
      // South
      Cell southNeighbour = new Cell();
      southNeighbour.setXPosition(xPosition);
      southNeighbour.setYPosition(yPosition + 1);
      log.info("Adding south neighbour");
      this.addNeighbour(southNeighbour);
      // South west
      if (this.canHaveWestNeighbours()) {
        Cell southWestNeighbour = new Cell();
        southWestNeighbour.setXPosition(xPosition - 1);
        southWestNeighbour.setYPosition(yPosition + 1);
        log.info("Adding south-west neighbour");
        this.addNeighbour(southWestNeighbour);
      }
      // South east
      if (this.canHaveEastNeighbours()) {
        Cell southEastNeighbour = new Cell();
        southEastNeighbour.setXPosition(xPosition + 1);
        southEastNeighbour.setYPosition(yPosition + 1);
        log.info("Adding south-east neighbour");
        this.addNeighbour(southEastNeighbour);
      }
    }
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
    graphicsContext.fillRect(this.getXPosition(), this.getYPosition(), WIDTH, HEIGHT);
    if (isAlive) {
      graphicsContext.setFill(Color.WHITE);
    } else {
      graphicsContext.setFill(Color.BLACK);
    }
    return this;
  }

  public void setGraphicsContext(GraphicsContext graphicsContext) {
    this.graphicsContext = graphicsContext;
  }

  public void addNeighbour(Cell neighbour) {
    this.neighbours.add(neighbour);
  }

  public boolean canHaveNorthNeighbours() {
    return this.yPosition > HEIGHT;
  }

  public boolean canHaveSouthNeighbours() {
    return this.yPosition + HEIGHT < graphicsContext.getCanvas().getHeight();
  }

  public boolean canHaveWestNeighbours() {
    return this.xPosition > WIDTH;
  }

  public boolean canHaveEastNeighbours() {
    return this.xPosition + WIDTH < graphicsContext.getCanvas().getWidth();
  }

  public List<Cell> getNeighbours() {
    return neighbours;
  }
}
