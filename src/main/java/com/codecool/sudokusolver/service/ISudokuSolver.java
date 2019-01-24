package com.codecool.sudokusolver.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ISudokuSolver {
   int[][] solve() throws IOException;
   int[][] uploadBoard(MultipartFile file) throws IOException;
   long elapsedTime();
}
