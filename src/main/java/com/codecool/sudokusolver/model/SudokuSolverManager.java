package com.codecool.sudokusolver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.*;

public class SudokuSolverManager implements Callable<Sudoku> {

    private Sudoku sudoku;

    public SudokuSolverManager(Sudoku sudoku) {
        this.sudoku = sudoku;
    }

    @Override
    public Sudoku call() throws ExecutionException, InterruptedException {
        List<Future<Sudoku>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        futures.add(executorService.submit(new SudokuSolver(sudoku)));
        ListIterator<Future<Sudoku>> listIterator = futures.listIterator();
        while (listIterator.hasNext()) {
            Future<Sudoku> future = listIterator.next();
            Sudoku sudoku = future.get();
            if (sudoku.isSolved()) {
                return sudoku;
            } else if (sudoku.haveMoreSolutions()) {
                List<Sudoku> sudokusPossibilities = sudoku.getAllPossibilities();
                for (Sudoku sudokuCopy : sudokusPossibilities) {
                    listIterator.add(executorService.submit(new SudokuSolver(sudokuCopy)));
                    listIterator.previous();
                }
            } else if (sudoku.isIncorrect()) {
                listIterator.remove();
            }
        }
        return null;
    }
}

