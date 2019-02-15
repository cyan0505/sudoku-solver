package com.codecool.sudokusolver.service;

import com.codecool.sudokusolver.model.Cell;
import com.codecool.sudokusolver.model.Sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuUtils {

    public static int[][] convertSudokuToIntArray(Sudoku sudoku) {
        List<Cell> cellList = sudoku.getCellList();
        int[][] sudokuArray = new int[9][9];
        for (Cell cell : cellList) {
            sudokuArray[cell.getRow()][cell.getColumn()] = cell.getValue();
        }
        return sudokuArray;
    }

    public static Sudoku convertIntArrayToSudoku(int[] sudoku) {
        List<Cell> cellList = new ArrayList<>();
        int counter = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellList.add(new Cell(i, j, sudoku[counter++]));
            }
        }
        return new Sudoku(cellList);
    }
}


