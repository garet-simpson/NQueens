package com.garetsimpson;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Date;

public class Reports {
    //object stores information about the current run
    //such as board length, number of queens, number of solutions
    //Has reports to display information
    private int numOfSolutions = 0;
    private int numOfMoves = 0;
    private int boardLength = 0;
    private int numOfQueens = 0;
    private int seconds = 0;
    private String stringSeconds;

    public String getStringSeconds() {
        return stringSeconds;
    }

    public void setStringSeconds(String stringSeconds) {
        this.stringSeconds = stringSeconds;
    }

    String space = "    ";
    Timer timer = new Timer();

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    public Reports() {

    }

    public void summaryHeader(){
        System.out.println("Board Size | Number of Queens | Solutions | Moves |  Time");
    }
    public void summary(){
        System.out.print(space(5) + getBoardLength());
        System.out.print(space(15) + getNumOfQueens());
        System.out.print(space(14) + getNumOfSolutions());
        System.out.print(space(8) + getNumOfMoves());
        System.out.print(space(10) + getSeconds());
        System.out.println();
    }

    public String space(int i){
        String spaceStr = "";
        for (int j = 0; j < i; j++) {
            spaceStr = spaceStr + " ";
        }
        return spaceStr;
    }

    public int getNumOfSolutions() {
        return numOfSolutions;
    }

    public void setNumOfSolutions(int numOfSolutions) {
        this.numOfSolutions = numOfSolutions;
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }

    public void setNumOfMoves(int numOfMoves) {
        this.numOfMoves = numOfMoves;
    }

    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }

    public int getNumOfQueens() {
        return numOfQueens;
    }

    public void setNumOfQueens(int numOfQueens) {
        this.numOfQueens = numOfQueens;
    }
}
