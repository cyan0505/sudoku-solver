package com.codecool.sudokusolver.model;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SudokuSolverManager {

    public static Sudoku solve(Sudoku sudokuToSolve) throws ExecutionException, InterruptedException {
        List<Future<Sudoku>> futures = new ArrayList<>();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        futures.add(executorService.submit(new SudokuSolver(sudokuToSolve)));
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

