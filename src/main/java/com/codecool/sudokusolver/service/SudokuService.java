package com.codecool.sudokusolver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class SudokuService {

    private FileParser fileParser;

    @Autowired
    public SudokuService(FileParser fileParser){
        this.fileParser = fileParser;
    }


    public int[][] solveSudoku(MultipartFile multipartFile) throws IOException, InterruptedException {

//        Sudoku sudoku = new Sudoku(fileParser.parseFile(multipartFile));

//        sudoku.solve();

        return null;

    }



}
