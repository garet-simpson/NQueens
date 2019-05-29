package com.garetsimpson;

public class NQueens {
    //Finds all solutions for n number of queens on a board of n length.
    // A solution is defined as a queen arrangement inwhich no two queens share a horizontal, vertical, or diagonal.
    private int numOfQueens = 0;
    private int boardLength = 0;
    private boolean firstRun = false;
    QueenPattern queenPattern;
    Board board;
    Queens queens;
    Reports reports = new Reports();
    SolutionPatterns solutionPatterns = new SolutionPatterns();

    public NQueens(int numOfQueens, int boardLength) {
        this.reports.timer.start();
        this.numOfQueens = numOfQueens;
        this.boardLength = boardLength;
        this.board = new Board(this.boardLength);
        this.queens = new Queens(this.numOfQueens);
        this.queenPattern = new QueenPattern(queens.getNumOfQueens(), board.getBoardLength());
        if(queenPattern.rowCounter.getBase()== 1){
            setFirstRun(true);
        }

        reports.setBoardLength(board.getBoardLength());
        reports.setNumOfQueens(queens.getNumOfQueens());
        board.clearQueens();
        board.loadQueens(queens.queenList);
        //board.draw();
    }



    public void getAllSolutionsFromPattern(){

        while (queenPattern.getNextSolution() != null || isFirstRun()){
            setFirstRun(false);
            reports.setNumOfSolutions(reports.getNumOfSolutions() + 1);
            solutionPatterns.add(queenPattern);
        }
        //reports.setStringSeconds(reports.timer.stop());
    }

    public void getAllSolutions() {

        while (queenPattern.getNextQueenPattern(queens) != null || isFirstRun() ) {
            setFirstRun(false);
            reports.setNumOfMoves(reports.getNumOfMoves() + 1);
            board.loadQueens(queenPattern.getCurrentQueenPattern(queens));

            if (board.validate()) {
                reports.setNumOfSolutions(reports.getNumOfSolutions() + 1);
                solutionPatterns.add(queenPattern);
            }
        }
    }

    public void drawAllSolutions(){
        for (int i = 0; i < solutionPatterns.queenPatterns.size(); i++) {
            System.out.println("Solution: " + (i+1));
            queens.updateQueenListWithQueenPattern(solutionPatterns.queenPatterns.get(i));
            board.loadQueens(queens.queenList);
            board.draw();
        }


    }
    public boolean isFirstRun() {
        return firstRun;
    }

    public void setFirstRun(boolean firstRun) {
        this.firstRun = firstRun;
    }
}


//    public NQueens() {
//
//
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Enter square board length: ");
//        Board board = new Board(scanner.nextInt());
//
//        System.out.print("Enter number of queens: ");
//        Queens queens = new Queens(scanner.nextInt());
//
//    }



//    public void initialize() {
//
//        QueenPattern queenPattern = new QueenPattern(queens.getNumOfQueens(),board.getBoardLength());
//        Reports reports = new Reports();
//        reports.setBoardLength(board.getBoardLength());
//        reports.setNumOfQueens(queens.getNumOfQueens());
//        board.clearQueens();
//        board.loadQueens(queens.queenList);
//        board.draw();
//
//        while(queenPattern.getNextQueenPattern(queens)!= null){
//            reports.setNumOfMoves(reports.getNumOfMoves()+1);;
//            board.loadQueens(queenPattern.getCurrentQueenPattern(queens));
//            //board.loadQueens(queenPattern.getValidPattern(queens));
//            //board.draw();
//
//            if (board.validate()) {
//                reports.setNumOfSolutions(reports.getNumOfSolutions()+1);
//                System.out.println("Solution: " + reports.getNumOfSolutions());
//                board.draw();
//            }
//        }
//        //board.draw();
//
//    }

