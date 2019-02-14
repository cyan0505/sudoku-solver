package com.codecool.sudokusolver.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Cell {
    private final int row;
    private final int column;
    private final int square;
    private volatile int value;
    private volatile List<Integer> possibleValues;

    public Cell(int row, int column, int value) {
        this.row = row;
        this.column = column;
        this.square = setSquare(row, column);
        this.value = value;
        if (value == 0) {
            this.possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        } else {
            this.possibleValues = new ArrayList<>();
        }
    }

    public Cell() {
        this.row = 1;
        this.column = 1;
        this.square = setSquare(row, column);
        this.value = 0;
        this.possibleValues = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
    }

    public Cell(Cell cell) {
        this.row = cell.getRow();
        this.column = cell.getColumn();
        this.square = cell.getSquare();
        this.value = cell.getValue();
        this.possibleValues = new ArrayList<>(cell.getPossibleValues());
    }

    public void setValue(int value) {
        this.value = value;
        this.possibleValues.clear();
    }

    public void removeValue(int value) {
        if (possibleValues.contains(value)) {
            this.possibleValues.remove(Integer.valueOf(value));
        }
    }

    static int setSquare(int row, int column) {
        if (row >= 0 && row <= 2 && column >= 0 && column <= 2) {
            return 0;
        } else if (row >= 0 && row <= 2 && column >= 3 && column <= 5) {
            return 1;
        } else if (row >= 0 && row <= 2 && column >= 6 && column <= 8) {
            return 2;
        } else if (row >= 3 && row <= 5 && column >= 0 && column <= 2) {
            return 3;
        } else if (row >= 3 && row <= 5 && column >= 3 && column <= 5) {
            return 4;
        } else if (row >= 3 && row <= 5 && column >= 6 && column <= 8) {
            return 5;
        } else if (row >= 6 && row <= 8 && column >= 0 && column <= 2) {
            return 6;
        } else if (row >= 6 && row <= 8 && column >= 3 && column <= 5) {
            return 7;
        } else if (row >= 6 && row <= 8 && column >= 6 && column <= 8) {
            return 8;
        }
        return 0;
    }
}
