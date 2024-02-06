package org.example.model;

import static org.example.util.constants.*;

public class Toy {
    private int x;
    private int y;
    private String direction;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public void place(int x, int y, String direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public boolean getIsPlaced() {
        return direction != null && direction != "";
    }

    public void toLeft(){
        switch (direction) {
            case "NORTH":
                direction = "WEST";
                break;
            case "WEST":
                direction = "SOUTH";
                break;
            case "SOUTH":
                direction = "EAST";
                break;
            default:
                direction = "NORTH";
                break;
        }
    }

    public void toRight(){
        switch (direction) {
            case "NORTH":
                direction = "EAST";
                break;
            case "EAST":
                direction = "SOUTH";
                break;
            case "SOUTH":
                direction = "WEST";
                break;
            default:
                direction = "NORTH";
                break;
        }
    }

    public void move(){
        switch (direction) {
            case "NORTH":
                y = y < MAX_Y ? y+1 : MAX_Y;
                break;
            case "EAST":
                x = x < MAX_X ? x+1 : MAX_X;
                break;
            case "SOUTH":
                y = y > MIN_Y ? y-1 : MIN_Y;
                break;
            default:
                x = x > MIN_X ? x-1 : MIN_X;
                break;
        }
    }

    public void report(){
        System.out.printf("Output: %d,%d,%s\n", x, y, direction);
    }
}
