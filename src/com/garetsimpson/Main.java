package com.garetsimpson;

public class Main {

    public static void main(String[] args) {



    }

    public static void getAndDrawAllSolutions(NQueens nQueens){
        //nQueens.getAllSolutions();
        nQueens.getAllSolutionsFromPattern();
        nQueens.drawAllSolutions();
    }

    public static void printQueenReport(int startQueenQuantity, int endQueenQuantity){
        for (int i = startQueenQuantity; i <= endQueenQuantity; i++) {
            NQueens nQueens = new NQueens(i,i);
            nQueens.getAllSolutionsFromPattern();
            if(i==1){
                nQueens.reports.summaryHeader();
            }
            nQueens.reports.summary();
        }
    }

}
