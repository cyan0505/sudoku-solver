package com.codecool.sudokusolver.model;

import com.codecool.sudokusolver.service.FileParser;
import org.junit.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import static org.junit.Assert.assertEquals;

public class SudokuTest {

    @Test
    public void testDeepCopy() throws IOException {
        FileParser parser = new FileParser();
        File file = new File("/home/bartosz/Codecool/Advanced/sudoku-solver/World's-hardest-sudoku.txt");
        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", Files.readAllBytes(file.toPath()));
        Sudoku sudoku = parser.parseFile(multipartFile);

        Sudoku result = sudoku.deepCopy();

        assertEquals(sudoku, result);
    }
}