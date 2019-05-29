package com.garetsimpson;

import java.util.ArrayList;

public class Queens {
    //An array of Queen objects is created
    //The queens are then updated with a queen patten
    ArrayList<Queen> queenList = new ArrayList<>();
    private int numOfQueens;



    public Queens(int numOfQueens) {
        this.numOfQueens = numOfQueens;
        this.create(numOfQueens);
    }

    public void create(int numOfQueens) {
        for (int i = 0; i < numOfQueens; i++) {
            Queen queen = new Queen();
            queen.setID("Queen" + i);
            queen.setX(0);
            queen.setY(i);
            queenList.add(queen);
        }
    }

    public void updateQueenListWithQueenPattern(QueenPattern queenPattern) {
        int queenCnt = 0;
        for (int i = 0; i < queenPattern.pattern.size(); i++) {
            if(queenPattern.pattern.get(i)!= -1){
                Queen queen = queenList.get(queenCnt);
                queen.setX(queenPattern.pattern.get(i));
                queen.setY(i);
                queenCnt++;
            }
        }
    }

    public int getNumOfQueens() {
        return numOfQueens;
    }

    public void setNumOfQueens(int numOfQueens) {
        this.numOfQueens = numOfQueens;
    }

}
