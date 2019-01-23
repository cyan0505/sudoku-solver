package com.codecool.sudokusolver.model;

import java.util.ArrayList;
import java.util.List;

public class Cell {

    private int column;
    private int row;
    private int value = 0;
    private List<Integer> possibleResults;


    public Cell(int column, int row, int value) {
        this.column = column;
        this.row = row;
        this.value = value;
        this.possibleResults = new ArrayList<>();
    }

    public Cell(int column, int row) {
        this(column, row, 0);
    }


    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public List<Integer> getPossibleResults() {
        return possibleResults;
    }

    public void setPossibleResults(List<Integer> possibleResults) {
        this.possibleResults = possibleResults;
    }
}
