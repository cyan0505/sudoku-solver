package com.codecool.sudokusolver;

import com.codecool.sudokusolver.service.FileParser;
import com.codecool.sudokusolver.service.ISudokuSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class Backtrack extends Thread implements ISudokuSolver {


    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int BOARD_START_INDEX = 0;
    private static final int BOARD_SIZE = 9;
    private FileParser fileParser;


    @Autowired
    public Backtrack(FileParser fileParser){
        this.fileParser = fileParser;
    }


    public void displayBoard(int[][] board) throws IOException {

    }



    public int[][] solve(MultipartFile file) throws IOException {

        int[][] toSolveBoard = fileParser.parseFile(file);

        new Thread(() -> {
            try {
                parseSudokuThroughAlgorithm(toSolveBoard);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();


        return toSolveBoard;
    }

    private boolean parseSudokuThroughAlgorithm(int[][] board) throws IOException {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {

            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {

                    for (int number = MIN_VALUE; number <= MAX_VALUE; number++) {
                        if (isOk(row, column, number, board)) {
                            board[row][column] = number;

                            if (parseSudokuThroughAlgorithm(board))
                                return true;
                            else {
                                board[row][column] = NO_VALUE;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }


    private boolean isInRow(int row, int number, int[][] board) {

        for(int i = 0; i < BOARD_SIZE; i++){
            if(board[row][i] == number)
                return true;
        }
        return false;
    }

    private boolean isInColumn(int col, int number, int[][] board) {

        for(int i = 0; i < BOARD_SIZE; i++){
            if(board[i][col] == number)
                return true;
        }
        return false;
    }

    private boolean isInSubsquare(int row, int col, int number, int[][] board){
        int r = row - row % 3;
        int c = col - col % 3;

        for(int i = r; i < r + 3; i++){
            for(int j = c; j < c + 3; j++){
                if(board[i][j] == number)
                    return true;
            }
        }
        return false;
    }

    private boolean isOk(int row, int col, int number, int[][] board){

        return !isInRow(row, number, board) && !isInColumn(col, number, board) && !isInSubsquare(row, col, number, board);
    }


}
