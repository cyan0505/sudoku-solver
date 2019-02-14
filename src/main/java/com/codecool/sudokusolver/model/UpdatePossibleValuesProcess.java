package com.codecool.sudokusolver.model;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UpdatePossibleValuesProcess implements Callable<Sudoku> {
    private Sudoku sudokuToSolve;

    public UpdatePossibleValuesProcess(Sudoku sudokuToSolve) {
        this.sudokuToSolve = sudokuToSolve;
    }

    @Override
    public Sudoku call() {
        List<Cell> cellList = sudokuToSolve.getCellList();
        for (Cell cell : cellList) {
            updatePossibleValues(cell, cellList);
        }
        return this.sudokuToSolve;
    }

    private void updatePossibleValues(Cell cell, List<Cell> cellList) {
        fieldConstraint(cell, cellList, Cell::getRow);
        fieldConstraint(cell, cellList, Cell::getColumn);
        fieldConstraint(cell, cellList, Cell::getSquare);
    }

    private void fieldConstraint(Cell cell, List<Cell> cellList, Function<Cell, Integer> getterFunc) {
        List<Cell> squareCells = cellList.stream()
                .filter(cell1 -> getterFunc.apply(cell1).equals(getterFunc.apply(cell)))
                .filter(cell1 -> cell1.getValue() != 0)
                .collect(Collectors.toList());
        for (Cell leftCell : squareCells) {
            if (cell.getPossibleValues().contains(leftCell.getValue())) {
                cell.removeValue(leftCell.getValue());
            }
        }
    }
}
