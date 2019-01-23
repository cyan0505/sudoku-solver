package com.codecool.sudokusolver.model;

import java.util.List;

public class RowManager implements Runnable{

    private Cell cell;
    private List<Cell> cellList;

    public RowManager(Cell cell, List<Cell> cellList) {
        this.cell = cell;
        this.cellList = cellList;
    }

    @Override
    public void run() {

        for (Cell cell : cellList) {
            if (cell.getRow() == this.cell.getRow()) {
                rowPossibleValues(cell);
            }

        }

    }

    private void rowPossibleValues(Cell cell) {
        if(cell.getValue() != this.cell.getValue()){
            this.cell.addValue(cell.getValue());
        }
    }



}
