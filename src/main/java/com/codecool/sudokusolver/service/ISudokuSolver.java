package com.codecool.sudokusolver.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ISudokuSolver {
   int[][] solve(MultipartFile file) throws IOException;
   void displayBoard(int[][] board) throws IOException;
}
