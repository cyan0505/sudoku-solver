package com.codecool.sudokusolver.service;

import com.codecool.sudokusolver.model.Cell;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class FileParser {

    public List<Cell> parseFile(MultipartFile multipartFile) {
        List<Cell> cells = new ArrayList<>();
        try {
            File file = convertFile(multipartFile);
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
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.synchronizedList(cells);
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
