package com.codecool.sudokusolver.service;

import com.codecool.sudokusolver.model.Cell;
import com.codecool.sudokusolver.model.Sudoku;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@Component
public class FileParser {
    public Sudoku parseFile(int[] cells) {
        List<Cell> cellList = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                cellList.add(new Cell(i, j, cells[index++]));

            }
        }
        return new Sudoku(cellList);
    }

    public Sudoku parseFile(MultipartFile multipartFile) throws IOException {

        File file = convertFile(multipartFile);
        List<Cell> cells = fromFileToCells(file);
        file.delete();
        return new Sudoku(Collections.synchronizedList(cells));
    }

    private List<Cell> fromFileToCells(File file) throws IOException {
        List<Cell> cells;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int rowCounter = 0;
        cells = new ArrayList<>();

        String line;
        while ((line = reader.readLine()) != null) {

            String[] row = line.split(",");
            for (int column = 0; column < row.length; column++) {
                cells.add(new Cell(rowCounter, column, Integer.valueOf(row[column])));
            }
            rowCounter++;
        }
        reader.close();
        return cells;
    }

    public Sudoku parseFile(File file) throws IOException {

        List<Cell> cells = fromFileToCells(file);

        return new Sudoku(Collections.synchronizedList(cells));
    }

    private File convertFile(MultipartFile file) throws IOException {
        File convFile = new File(Objects.requireNonNull(file.getOriginalFilename()));
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
