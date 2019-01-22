package com.codecool.sudokusolver.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileParser {


    public int[][] parseFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        List<String> lines = new ArrayList<>();
        List<int[]> sudokuBoard = new ArrayList<>();
        int counter = 0;
        int[][] board = new int[9][9];

        String line = null;

        while((line = reader.readLine()) != null) {

            String[] row = line.split(",");
            int[] sudokuRow = Arrays.asList(row).stream().mapToInt(Integer::parseInt).toArray();
            sudokuBoard.add(sudokuRow);

            for(int i = 0; i < sudokuRow.length; i++){
                board[counter][i] = sudokuRow[i];
            }

            counter++;
        }

        reader.close();
        return board;
    }


}
