package com.garetsimpson;


public class Queen {
    //Queen object stores and x and y location.
    private int x;
    private int y;
    private String ID;

    public Queen() {

    }

    public void move(int x, int y) {
        this.setX(x);
        this.setY(y);
    }



    public int getX() {
        return x;
    }

    public void setX(int x) { this.x = x; }

    public int getY() {
        return y;
    }

    public void setY(int y) { this.y = y; }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

}
