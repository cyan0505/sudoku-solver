package com.codecool.sudokusolver.service;

import org.springframework.web.multipart.MultipartFile;

public interface ISudokuSolver {
   int[][] solve(MultipartFile file);
}
