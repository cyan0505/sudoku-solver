package com.codecool.sudokusolver.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;


@Data
public class Cell {

    private final int column;
    private final int row;
    private int value;
    private int square;
    private List<Integer> possibleResults;


    public Cell(int column, int row, int value) {
        this.column = column;
        this.row = row;
        this.value = value;
        this.possibleResults = new ArrayList<>();
        setSquare(row, column);
    }


    public void addValue(int value){
        this.possibleResults.add(value);
    }


    private void setSquare(int row, int column) {

        if(row <= 3 && column <= 3){
            this.square = 1;
        } else if (row >= 1 && row <= 3 && column >= 4 && column <= 6){
            this.square = 2;
        } else if (row >= 1 && row <= 3 && column >= 7) {
            this.square = 3;
        } else if (row >= 4 && row <= 6 && column >= 1 && column <= 3) {
            this.square = 4;
        } else if (row >= 4 && row <= 6 && column >= 4 && column <= 6) {
            this.square = 5;
        } else if (row >= 4 && row <= 6 && column >= 7) {
            this.square = 6;
        } else if (row >= 7 && column <= 3) {
            this.square = 7;
        } else if (row >= 7 && column >= 4 && column <= 6) {
            this.square = 8;
        } else if ( row >= 7 && column >= 7) {
            this.square = 9;
        }

    }



}
