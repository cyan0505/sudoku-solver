package com.codecool.sudokusolver.service;

import com.codecool.sudokusolver.model.Cell;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FileParser {


//    public int[][] parseFile(MultipartFile multipartFile) throws IOException {
//
//        File file = convertFile(multipartFile);
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        List<String> lines = new ArrayList<>();
//        int counter = 0;
//        int[][] board = new int[9][9];
//        String line = null;
//
//        while((line = reader.readLine()) != null) {
//
//            String[] row = line.split(",");
//            int[] sudokuRow = Arrays.asList(row).stream().mapToInt(Integer::parseInt).toArray();
//            System.arraycopy(sudokuRow, 0, board[counter], 0, sudokuRow.length);
//            counter++;
//        }
//        reader.close();
//        return board;
//    }


    public List<Cell> parseFile(MultipartFile multipartFile) throws IOException {

        File file = convertFile(multipartFile);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        int rowCounter = 0;
        List<Cell> cells = new ArrayList<>();

        String line = null;

        while((line = reader.readLine()) != null) {

            String[] row = line.split(",");
            for(int column = 0; column < row.length; column++){
                cells.add(new Cell(rowCounter, column, Integer.valueOf(row[column])));
            }
            rowCounter++;
        }
        reader.close();
        return cells;
    }



    private File convertFile(MultipartFile file) throws IOException{
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }


}
