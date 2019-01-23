package com.codecool.sudokusolver.model;

import java.util.List;

public class SquareManager implements Runnable{

    private Cell cell;
    private List<Cell> cellList;

    public SquareManager(Cell cell, List<Cell> cellList) {
        this.cell = cell;
        this.cellList = cellList;
    }

    @Override
    public void run() {

        for(Cell cell : cellList){
            if(cell.getSquare() == this.cell.getSquare()){
                squarePossibleValues(cell);
            }
        }

    }


    private void squarePossibleValues(Cell cell) {
        if(cell.getValue() != this.cell.getValue()) {
            this.cell.addValue(cell.getValue());
        }
    }

}
