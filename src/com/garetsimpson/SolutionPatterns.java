package com.garetsimpson;

import java.util.ArrayList;

public class SolutionPatterns {
    //This is an array of QueenPatterns that are solutions.
    //This allows all solutions to be found and stored in an array before
    //moving onto the drawing the board.

    ArrayList<QueenPattern> queenPatterns = new ArrayList<>();

    public void add(QueenPattern queenPattern){

        QueenPattern solutionPattern = new QueenPattern(queenPattern.getNumOfQueens(),queenPattern.getBoardLength());
        for (int i = 0; i < queenPattern.pattern.size(); i++) {
            solutionPattern.pattern.set(i,queenPattern.pattern.get(i));
        }
       queenPatterns.add(solutionPattern);

    }



    public ArrayList<QueenPattern> getQueenPatterns() {
        return queenPatterns;
    }

    public void setQueenPatterns(ArrayList<QueenPattern> queenPatterns) {
        this.queenPatterns = queenPatterns;
    }
}
