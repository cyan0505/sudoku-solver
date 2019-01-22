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
        int counter = 0;
        int[][] board = new int[9][9];

        String line = null;

        while((line = reader.readLine()) != null) {

            String[] row = line.split(",");
            int[] sudokuRow = Arrays.asList(row).stream().mapToInt(Integer::parseInt).toArray();
            System.arraycopy(sudokuRow, 0, board[counter], 0, sudokuRow.length);
            counter++;
        }

        reader.close();
        return board;
    }


    public void display(int[][] table) {
        for(int[] element : table){
            System.out.println(Arrays.toString(element));
        }
    }
}
