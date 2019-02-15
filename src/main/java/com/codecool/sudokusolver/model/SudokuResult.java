package com.codecool.sudokusolver.model;

import lombok.Data;

@Data
public class SudokuResult {
    private int[][] sudoku;
    private long elapsedTime;

    public SudokuResult(int[][] sudoku, long elapsedTime) {
        this.sudoku = sudoku;
        this.elapsedTime = elapsedTime;
    }
}
