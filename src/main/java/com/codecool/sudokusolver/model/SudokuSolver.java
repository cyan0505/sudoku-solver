package com.codecool.sudokusolver.model;

import java.util.concurrent.*;

public class SudokuSolver implements Callable<Sudoku> {
    private Sudoku sudokuToSolve;

    public SudokuSolver(Sudoku sudokuToSolve) {
        this.sudokuToSolve = sudokuToSolve;
    }

    @Override
    public Sudoku call() throws ExecutionException {
        try {
            ExecutorService executorService = Executors.newSingleThreadExecutor();
            Future<Sudoku> updatedPossibleValuesSudoku;
            Future<Sudoku> updatedValuesSudoku;
            do {
                updatedPossibleValuesSudoku = executorService.submit(new UpdatePossibleValuesProcess(sudokuToSolve));
                updatedPossibleValuesSudoku.get();
                updatedValuesSudoku = executorService.submit(new UpdateValuesProcess(sudokuToSolve));
                updatedValuesSudoku.get();
            } while (!this.sudokuToSolve.isSolved() && !this.sudokuToSolve.haveMoreSolutions() && !this.sudokuToSolve.isIncorrect());
            return sudokuToSolve;
        } catch (InterruptedException e) {
            return this.sudokuToSolve;
        }
    }
}
