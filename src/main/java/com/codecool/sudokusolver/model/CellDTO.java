package com.codecool.sudokusolver.model;

public class CellDTO {

    private String value;

    public CellDTO(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "SudokuCell{" +
                "value='" + value + '\'' +
                '}';
    }
}