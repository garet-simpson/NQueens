package com.garetsimpson;

public class Square {

    //This is a square object with an X, Y and hasQueen properties
    private int x;
    private int y;
    private String ID;
    private boolean hasQueen;
    public Square() {

    }

    public int getX() {
        return x;
    }

    public boolean getHasQueen() {
        return hasQueen;
    }

    public void setHasQueen(boolean hasQueen) {
        this.hasQueen = hasQueen;
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

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
}
