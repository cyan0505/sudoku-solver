package com.codecool.sudokusolver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SudokuCellList {

    private ArrayList<SudokuCell> sudokuCells;


    public ArrayList<SudokuCell> getSudokuCells() {
        return sudokuCells;
    }

    public void setSudokuCells(ArrayList<SudokuCell> sudokuCells) {
        this.sudokuCells = sudokuCells;
    }
}
