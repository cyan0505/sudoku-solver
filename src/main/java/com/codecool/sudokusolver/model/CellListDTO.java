package com.codecool.sudokusolver.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CellListDTO {

    private List<CellDTO> sudokuCells;

    public CellListDTO (List<CellDTO> sudokuCells) {
        this.sudokuCells = sudokuCells;
    }

    public List<CellDTO> getSudokuCells() {
        return sudokuCells;
    }

    @Override
    public String toString() {
        return "SudokuCellList{" +
                "sudokuCells=" + sudokuCells +
                '}';
    }
}