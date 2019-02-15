package com.codecool.sudokusolver.service;

import com.codecool.sudokusolver.model.Sudoku;
import com.codecool.sudokusolver.model.SudokuResult;
import com.codecool.sudokusolver.model.SudokuSolverManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

@Service
public class SudokuService implements ISudokuSolver{

    private FileParser fileParser;

    @Autowired
    public SudokuService(FileParser fileParser){
        this.fileParser = fileParser;
    }

    @Override
    public SudokuResult solve(MultipartFile file) throws IOException, ExecutionException, InterruptedException {
        Sudoku sudoku = fileParser.parseFile(file);
        long starttime = System.currentTimeMillis();
        Sudoku solvedSudoku = SudokuSolverManager.solve(sudoku);
        long endtime = System.currentTimeMillis();
        return new SudokuResult(SudokuUtils.convertSudokuToIntArray(solvedSudoku), starttime - endtime);
    }

    @Override
    public SudokuResult solve(int[] cellsValues) throws ExecutionException, InterruptedException {
        long starttime = System.currentTimeMillis();
        Sudoku solvedSudoku = SudokuSolverManager.solve(SudokuUtils.convertIntArrayToSudoku(cellsValues));
        long endtime = System.currentTimeMillis();

        return new SudokuResult(SudokuUtils.convertSudokuToIntArray(solvedSudoku), starttime - endtime);
    }

    @Override
    public int[][] uploadBoard(MultipartFile file) throws IOException {
        Sudoku sudoku = fileParser.parseFile(file);
        return SudokuUtils.convertSudokuToIntArray(sudoku);
    }

    @Override
    public int[][] uploadExampleBoard(File file) throws IOException {
        Sudoku sudoku = fileParser.parseFile(file);
        return SudokuUtils.convertSudokuToIntArray(sudoku);
    }
}
