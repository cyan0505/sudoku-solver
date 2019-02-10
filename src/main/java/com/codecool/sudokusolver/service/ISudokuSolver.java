package com.codecool.sudokusolver.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

public interface ISudokuSolver {
   int[][] solve() throws IOException;
   int[][] uploadBoard(MultipartFile file) throws IOException;
   int[][] uploadExampleBoard(File file) throws IOException;
   void generateUserGrid(String[][] userGrid) throws IOException;
   long elapsedTime();
}
