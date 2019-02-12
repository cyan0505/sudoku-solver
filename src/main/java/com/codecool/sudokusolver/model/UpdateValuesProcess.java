package com.codecool.sudokusolver.model;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;

public class UpdateValuesProcess implements Callable<Sudoku> {

    private Sudoku sudokuToSolve;

    public UpdateValuesProcess(Sudoku sudokuToSolve) {
        this.sudokuToSolve = sudokuToSolve;
    }

    @Override
    public Sudoku call() {
        List<Cell> cellsWithOnePossibleValue = this.sudokuToSolve.getCellList()
                .stream()
                .filter(cell -> cell.getPossibleValues().size() == 1 && cell.getValue() == 0)
                .collect(Collectors.toList());
        for (Cell cell : cellsWithOnePossibleValue) {
            cell.setValue(cell.getPossibleValues().get(0));
        }
        return this.sudokuToSolve;
    }
}
