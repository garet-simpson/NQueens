package com.garetsimpson;



public class NQueensTest {
    //Class to print all 92 board solutions
    public static void main(String[] args) {

        //set queen count and board number to 8
        int i = 8;
        NQueens nQueens = new NQueens(i,i);

        Main.getAndDrawAllSolutions(nQueens);
        nQueens.reports.summaryHeader();
        nQueens.reports.summary();

    }
}
