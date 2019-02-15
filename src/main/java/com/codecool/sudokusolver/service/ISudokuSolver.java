package com.codecool.sudokusolver.service;

import com.codecool.sudokusolver.model.SudokuResult;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

public interface ISudokuSolver {
    SudokuResult solve(MultipartFile file) throws IOException, ExecutionException, InterruptedException;
    SudokuResult solve(int[] cellsValues) throws IOException, ExecutionException, InterruptedException;
    int[][] uploadBoard(MultipartFile file) throws IOException;
    int[][] uploadExampleBoard(File file) throws IOException;
}
