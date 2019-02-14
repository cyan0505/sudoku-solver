package com.codecool.sudokusolver.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Sudoku {
    private volatile List<Cell> cellList;

    public Sudoku(List<Cell> cellList) {
        this.cellList = cellList;
    }

    public boolean isIncorrect() {
        return this.cellList
                .stream()
                .anyMatch(cell -> cell.getValue() == 0 && cell.getPossibleValues().size() == 0);
    }

    public boolean isSolved() {
        return this.cellList
                .stream()
                .allMatch(cell -> cell.getValue() != 0);
    }

    public boolean haveMoreSolutions() {
        return this.cellList
                .stream()
                .filter(cell -> cell.getValue() == 0)
                .allMatch(cell -> cell.getPossibleValues().size() >= 2);
    }

    public Sudoku deepCopy() {
        List<Cell> cellList = new ArrayList<>();
        for (Cell cell : this.cellList) {
            cellList.add(new Cell(cell));
        }
        return new Sudoku(cellList);
    }

    private Cell getCellWithMinimumPossibilities() {
        Cell minCell = new Cell();
        for (Cell cell : this.cellList) {
            if (cell.getValue() == 0) {
                if (cell.getPossibleValues().size() < minCell.getPossibleValues().size()) {
                    minCell = cell;
                }
            }
        }
        return minCell;
    }

    private Cell getCell(int row, int column) {
        for (Cell cell : this.cellList) {
            if (cell.getRow() == row && cell.getColumn() == column) {
                return cell;
            }
        }
        return new Cell(-1, -1, -1);
    }

    public String toString() {
        StringBuilder sudokuBuilder = new StringBuilder();
        for (int i = 0; i < 81; i++) {
            if (i != 0 && i % 27 == 0) {
                sudokuBuilder.append("\n - - - - - - - - - - - ");
            }
            if (i != 0 && i % 9 == 0) {
                sudokuBuilder.append("\n");
            }
            if ( i%9 != 0 && i % 3 == 0) {
                sudokuBuilder.append(" | ");
            } else {
                sudokuBuilder.append(" ");
            }
            sudokuBuilder.append(cellList.get(i).getValue());
        }
        return sudokuBuilder.toString();
    }

    public List<Sudoku> getAllPossibilities() {
        Cell minCell = this.getCellWithMinimumPossibilities();
        List<Sudoku> sudokus = new ArrayList<>();

        for (Integer value : minCell.getPossibleValues()) {
            Sudoku sudokuCopy = this.deepCopy();
            sudokuCopy.getCell(minCell.getRow(), minCell.getColumn()).setValue(value);
            sudokus.add(sudokuCopy);
        }
        return sudokus;
    }
}
