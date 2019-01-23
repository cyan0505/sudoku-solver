package com.codecool.sudokusolver.model;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Sudoku {

    private List<Cell> cellList;


    public Sudoku(List<Cell> cellList) {
        this.cellList = cellList;
    }


    public boolean solve() {
        ExecutorService executorService = Executors.newFixedThreadPool(100);

        for(Cell cell : cellList){
            if(isValueZero(cell)){
                executorService.execute(new RowManager(cell, cellList));
            }
        }


        return false;
    }


    private boolean isValueZero(Cell cell) {
        return cell.getValue() == 0;
    }



}
