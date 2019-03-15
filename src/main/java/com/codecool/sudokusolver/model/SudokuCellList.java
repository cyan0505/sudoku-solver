package com.codecool.sudokusolver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SudokuCellList {

    private ArrayList<SudokuCell> sudokuCells;

    public SudokuCellList(ArrayList<SudokuCell> sudokuCells) {
        this.sudokuCells = sudokuCells;
    }

    public ArrayList<SudokuCell> getSudokuCells() {
        return sudokuCells;
    }

    public void setSudokuCells(ArrayList<SudokuCell> sudokuCells) {
        this.sudokuCells = sudokuCells;
    }

    @Override
    public String toString() {
        return "SudokuCellList{" +
                "sudokuCells=" + sudokuCells +
                '}';
    }
}
