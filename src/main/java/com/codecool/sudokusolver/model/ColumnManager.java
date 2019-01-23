package com.codecool.sudokusolver.model;

import java.util.List;

public class ColumnManager implements Runnable {

    private List<Cell> cellList;
    private Cell cell;

    public ColumnManager(List<Cell> cellList, Cell cell) {
        this.cell = cell;
        this.cellList = cellList;
    }

    @Override
    public void run() {
        for (Cell cell : cellList) {
            if (cell.getColumn() == this.cell.getColumn()) {
                columnPossibleValues(cell);
            }
        }
    }

    private void columnPossibleValues(Cell cell) {
        if (cell.getValue() != this.cell.getValue()) {
            this.cell.addValue(cell.getValue());
;        }
    }
}
