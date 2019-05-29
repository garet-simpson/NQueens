package com.garetsimpson;
import java.util.ArrayList;

public class Board {
    //Board object is a collection of squares.
    //Original attempt put the validation step here.
    //Validation has since been moved to the QueenPattern class to speed up program.
    //The Board is first loaded with a Queens object.
    //Then the board is drawn

    ArrayList<Square> squares = new ArrayList();
    ArrayList<Integer> checkRowArray = new ArrayList();
    ArrayList<Integer> checkColArray = new ArrayList();
    private int boardLength = 0;

    public Board(int boardLength) {
        this.boardLength = boardLength;
        for (int i = 0; i < boardLength; i++) {
            checkRowArray.add(-1);
            checkColArray.add(-1);

            for (int j = 0; j < boardLength; j++) {
                Square square = new Square();
                square.setHasQueen(false);
                square.setX(i);
                square.setY(j);
                square.setID("square" + i + j);
                squares.add(square);
            }
        }
    }

    public int getBoardLength() {
        return boardLength;
    }

    public void setBoardLength(int boardLength) {
        this.boardLength = boardLength;
    }

    //part of legacy validation
    public void resetCheckRow() {
        for (int i = 0; i < boardLength; i++) {
            checkRowArray.set(i,-1);
        }
    }

    //part of legacy validation
    public void resetCheckCol() {
        for (int i = 0; i < boardLength; i++) {
            checkColArray.set(i,-1);
        }
    }

    //Clears all queens from the board
    public void clearQueens() {
        for (Square square : squares) {
            square.setHasQueen(false);
        }
    }

    //Board is loaded with a Queens object.
    //The hasQueen flag is set of square that match a queen's X and Y coordinates
    public void loadQueens(ArrayList<Queen> queens){
        clearQueens();
        for (Queen queen : queens) {
            for (Square square: squares) {
                if(square.getX() == queen.getX() && square.getY() == queen.getY()){
                        square.setHasQueen(true);
                }
            }
        }
    }

    //Legacy validation checking if current board is valid
    public boolean validate() {
        int queenIndex = 0;
        double xDistance = 0;
        double yDistance = 0;
        double slope = 0;
        this.resetCheckRow();
        this.resetCheckCol();
        for (Square square: squares) {
            if(square.getHasQueen()){
                checkRowArray.set(queenIndex, square.getX());
                checkColArray.set(queenIndex, square.getY());
                queenIndex++;
            }
        }
        for (int j = 0; j < queenIndex; j++) {
            for (int k = 0; k < queenIndex; k++) {
                if(j!=k) {
                    if (checkRowArray.get(j) == checkRowArray.get(k)) {
                        return false;
                    }

                    if (checkColArray.get(j) == checkColArray.get(k)) {
                        return false;
                    }
                    xDistance = checkRowArray.get(j) - checkRowArray.get(k);
                    yDistance = checkColArray.get(j) - checkColArray.get(k);

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

    //draws current board to terminal
    public void draw() {
        int rowCnt = 0;
        System.out.print(" ");
        for (int i = 0; i < boardLength; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        System.out.print(rowCnt);
        rowCnt++;
        for (Square square : squares) {
            if (square.getHasQueen()) {
                System.out.print("|Q");
            }else {
                System.out.print("| ");
            }
            if (square.getY() == boardLength-1 ) {
                if (rowCnt < boardLength) {
                    System.out.println("| ");
                    System.out.print(rowCnt);
                    rowCnt++;
                } else {
                    System.out.println("| ");
                }
            }
        }
    }
}
