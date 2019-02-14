package com.codecool.sudokusolver.model;

public class SudokuCell {

    private String id;
    private String value;

    public SudokuCell(String id, String value) {
        this.id = id;
        this.value = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SudokuCell{" +
                "id='" + id + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
