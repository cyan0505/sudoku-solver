package com.codecool.sudokusolver;

import com.codecool.sudokusolver.service.FileParser;
import com.codecool.sudokusolver.service.ISudokuSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.*;
import java.util.stream.IntStream;


@Service
public class Backtrack implements ISudokuSolver {


    private static final int NO_VALUE = 0;
    private static final int MIN_VALUE = 1;
    private static final int MAX_VALUE = 9;
    private static final int BOARD_START_INDEX = 0;
    private static final int SUBSECTION_SIZE = 3;
    private static final int BOARD_SIZE = 9;
    private FileParser fileParser;
    private int[][] sudokuBoard;
    private static boolean flagRow;
    private static boolean flagCol;
    private static boolean flagSubsquare;
    private ExecutorService e = Executors.newFixedThreadPool(1);

    private long startTime;
    private long endTime;
    public static long elapsedTime;


    @Autowired
    public Backtrack(FileParser fileParser){
        this.sudokuBoard = new int[9][9];
        this.fileParser = fileParser;
    }

    public long elapsedTime(){
        return elapsedTime;
    }

    public int[][] getSudokuBoard(){
        return this.sudokuBoard;
    }

    public int[][] uploadBoard(MultipartFile file) throws IOException {
        this.sudokuBoard = fileParser.parseFile(file);
        return fileParser.parseFile(file);
    }

    @Override
    public int[][] uploadExampleBoard(File file) throws IOException {
        this.sudokuBoard = fileParser.parseExampleFile(file);
        return fileParser.parseExampleFile(file);
    }

    @Override
    public void generateUserGrid(String[][] userGrid) throws IOException {
        int[][] userGridToSolve = this.sudokuBoard;

        for(int i = 0; i < userGrid.length; i++){
            for(int k = 0; k < userGrid[i].length; k++) {
                if(userGrid[i][k].equals(" ")){
                    userGridToSolve[i][k] = 0;
                } else {
                    userGridToSolve[i][k] = Integer.valueOf(userGrid[i][k]);
                }
            }
        }
    }


    public int[][] solve() throws IOException {
        this.startTime = System.currentTimeMillis();
        int[][] toSolveBoard = this.sudokuBoard;

        try {
            parseSudokuThroughAlgorithm(toSolveBoard);
        } catch (ExecutionException | InterruptedException e1) {
            e1.printStackTrace();
        }


        this.endTime = System.currentTimeMillis();
        this.elapsedTime = endTime - this.startTime;
        return toSolveBoard;
    }

    private boolean parseSudokuThroughAlgorithm(int[][] board) throws ExecutionException, InterruptedException {
        for (int row = BOARD_START_INDEX; row < BOARD_SIZE; row++) {

            for (int column = BOARD_START_INDEX; column < BOARD_SIZE; column++) {
                if (board[row][column] == NO_VALUE) {
                    for (int k = MIN_VALUE; k <= MAX_VALUE; k++) {
                        board[row][column] = k;
                        if (isValid(board, row, column) && parseSudokuThroughAlgorithm(board)) {
                            return true;
                        }
                        board[row][column] = NO_VALUE;
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValid(int[][] board, int row, int column) throws ExecutionException, InterruptedException {

//        Runnable r1 = () -> flagRow = rowConstraint(board, row);
//
//        Runnable r2 = () -> flagCol = columnConstraint(board, column);
//
//        Runnable r3 = () -> flagSubsquare = subsectionConstraint(board, row, column);
//
//        final Future<?> f1 = e.submit(r1);
//        final Future<?> f2 = e.submit(r2);
//        final Future<?> f3 = e.submit(r3);
//
//            f1.get();
//            f2.get();
//            f3.get();

        return rowConstraint(board, row) && columnConstraint(board, column) && subsectionConstraint(board, row, column);
    }

    private boolean rowConstraint(int[][] board, int row) {

        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
                .allMatch(column -> checkConstraint(board, row, constraint, column));
    }

    private boolean columnConstraint(int[][] board, int column) {

        boolean[] constraint = new boolean[BOARD_SIZE];
        return IntStream.range(BOARD_START_INDEX, BOARD_SIZE)
                .allMatch(row -> checkConstraint(board, row, constraint, column));
    }

    private boolean subsectionConstraint(int[][] board, int row, int column) {

        boolean[] constraint = new boolean[BOARD_SIZE];
        int subsectionRowStart = (row / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionRowEnd = subsectionRowStart + SUBSECTION_SIZE;

        int subsectionColumnStart = (column / SUBSECTION_SIZE) * SUBSECTION_SIZE;
        int subsectionColumnEnd = subsectionColumnStart + SUBSECTION_SIZE;

        for (int r = subsectionRowStart; r < subsectionRowEnd; r++) {
            for (int c = subsectionColumnStart; c < subsectionColumnEnd; c++) {
                if (!checkConstraint(board, r, constraint, c)) return false;
            }
        }
        return true;
    }

    private boolean checkConstraint(int[][] board, int row, boolean[] constraint, int column) {

        if (board[row][column] != NO_VALUE) {
            if (!constraint[board[row][column] - 1]) {
                constraint[board[row][column] - 1] = true;
            } else {
                return false;
            }
        }
        return true;
    }


}
