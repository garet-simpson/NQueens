package com.garetsimpson;

import java.util.ArrayList;

public class QueenPattern {
    //Runs through all possible queenpatterns and varifies if they are solutions.


    BaseCounter rowCounter;
    BaseCounter colCounter;
    ArrayList<Integer> pattern = new ArrayList<Integer>();




    private int numOfQueens = 0;
    private int boardLength = 0;
    private int colCnt = 0;
    private int rowCnt = 0;
    private int colMax = 0;
    private int rowMax = 0;
    private boolean nextFlag = true;
    private boolean isSolution = false;



    public QueenPattern(int numOfQueens, int boardLength) {
        this.numOfQueens = numOfQueens;
        this.boardLength = boardLength;
        this.rowCounter = new BaseCounter(boardLength, boardLength);
        this.colCounter = new BaseCounter(2, boardLength);
        this.colMax = colCounter.getBaseTenMax();
        this.rowMax = rowCounter.getBaseTenMax();
        for (int i = 0; i < boardLength; i++) {
            pattern.add(0);
        }
        for (int i = 0; i < numOfQueens; i++) {
            colCounter.set(i,1);
        }
        rowCounter.toBaseTen();
        colCounter.toBaseTen();

    }

    //used to find a queen pattern one at a time.
    public ArrayList<Queen> getNextQueenPattern(Queens queens) {

        this.getNextWithNumOfQueens();

        if(this.isNextFlag()) {
            this.updatePattern();
            queens.updateQueenListWithQueenPattern(this);
        }else{
            return null;
        }
        return queens.queenList;
    }

    public ArrayList<Queen> getCurrentQueenPattern(Queens queens){
        return queens.queenList;
    }

    public void getNext() {
        int rowCnt = rowCounter.toBaseTen();
        int colCnt = colCounter.toBaseTen();

        if(rowCnt == rowMax && colCnt == colMax) {
            setNextFlag(false);
        }else if(rowCnt == rowMax){
            rowCounter.reset();
            colCounter.increment();
        }else{
            rowCounter.increment();
        }

    }

    //Faster version
    public void getNextWithNumOfQueens(){
        boolean rowLoop = false;
        colCounter.updateNonZeroCnt();
        while(colCounter.getNonZeroCnt()!= numOfQueens && colCounter.toBaseTen() != colMax){
            colCounter.increment();
            colCounter.updateNonZeroCnt();
            //this.getNext();
            rowLoop = true;
        }
        rowCounter.updateZeroCnt();
        while(rowCounter.getZeroCnt() > 1 && rowCounter.toBaseTen() != rowMax ){//8 - numOfQueens +&& !rowLoop
            rowCounter.increment();
            rowCounter.updateZeroCnt();
            //this.getNext();
            rowLoop = true;
        }

        if(!rowLoop){
            this.getNext();
        }


    }



    public ArrayList<Integer> getNextSolution(){
        setSolution(false);
        colCounter.updateNonZeroCnt();

        while(colCounter.getBaseTen() != colMax || rowCounter.getBaseTen() != rowMax){
            while(colCounter.getNonZeroCnt()!= numOfQueens && colCounter.toBaseTen() != colMax){
                colCounter.increment();
                colCounter.updateNonZeroCnt();
                rowCounter.reset();
                colCounter.toBaseTen();
                rowCounter.toBaseTen();
            }

            while(rowCounter.getBaseTen() != rowMax ){
                if(rowCounter.getBaseTen() != rowMax){

                }

                rowCounter.increment();
                rowCounter.toBaseTen();

                this.updatePattern();
                if(rowCounter.hasNoDoubles() && hasDiagonal()){
                    return pattern;
                }

            }
        }
//        if(rowCounter.getBase() == 1){
//            this.updatePattern();
//        }
        return null;
    }

    public boolean hasDiagonal(){

        double xDistance = 0;
        double yDistance = 0;
        double slope = 0;
        for (int i = 0; i < pattern.size(); i++) {
            for (int j = 0; j < pattern.size(); j++) {
                if(i != j ) {
                    xDistance = pattern.get(i) - pattern.get(j);
                    yDistance = i - j;

                    try {
                        slope = xDistance / yDistance;
                    } catch (Exception e) {
                        e.printStackTrace();
                        slope = 0;
                    }

                    if (Math.abs(slope) == 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void updatePattern(){
        for (int k = 0; k < pattern.size(); k++) {
            if(colCounter.get(k)==1){
                pattern.set(k,rowCounter.get(k));
            }else{
                pattern.set(k,-1);
            }
        }

    }

    public int get(int i){
        return pattern.get(i);
    }

    public void set(int i,int value){
        pattern.set(i,value);
    }

    public boolean isNextFlag() {
        return nextFlag;
    }

    public void setNextFlag(boolean nextFlag) {
        this.nextFlag = nextFlag;
    }

    public ArrayList<Queen> getValidPattern(Queens queens) {

        queens.queenList.get(0).setX(2);
        queens.queenList.get(1).setX(5);
        queens.queenList.get(2).setX(3);
        queens.queenList.get(3).setX(1);
        queens.queenList.get(4).setX(7);
        queens.queenList.get(5).setX(4);
        queens.queenList.get(6).setX(6);
        //QueenList.get(7).setX(-1);

        return queens.queenList;
    }

    public int getNumOfQueens() {
        return numOfQueens;
    }

    public void setNumOfQueens(int numOfQueens) {
        this.numOfQueens = numOfQueens;
    }


    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }

    public boolean isSolution() {
        return isSolution;
    }

    public void setSolution(boolean solution) {
        isSolution = solution;
    }

}

