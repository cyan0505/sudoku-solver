package com.codecool.sudokusolver.controller;

import com.codecool.sudokusolver.model.CellDTO;
import com.codecool.sudokusolver.model.CellListDTO;
import com.codecool.sudokusolver.model.SudokuResult;
import com.codecool.sudokusolver.service.ISudokuSolver;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
public class WebController {
    private ISudokuSolver sudokuSolver;

    @Autowired
    public WebController(ISudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }


    @PostMapping("/solve")
    public String handleSolvedSudoku(HttpEntity<String> request, Model model) {
        Gson g = new Gson();
        String json = request.getBody();
        CellListDTO sudokuCells = g.fromJson(json, CellListDTO.class);
        List<CellDTO> cells = sudokuCells.getSudokuCells();
        int[] values = cells.stream().mapToInt(cellDTO -> Integer.valueOf(cellDTO.getValue())).toArray();
        SudokuResult sudokuResult;
        try {
            sudokuResult = sudokuSolver.solve(values);
        } catch (Exception e) {
            return "error";
        }
        model.addAttribute("solvedSudoku", sudokuResult.getSudoku());
        model.addAttribute("fileName", "Unknown");
        model.addAttribute("time", sudokuResult.getElapsedTime());
        return "result";
    }

    @PostMapping("/upload")
    public String uploadHandler(@RequestParam MultipartFile file, Model model) {
        try {
            model.addAttribute("sudoku", sudokuSolver.uploadBoard(file));
            model.addAttribute("fileName", file.getOriginalFilename());
        } catch (IOException e) {
            return "error";
        }
        return "sudoku";
    }


    @PostMapping("/example")
    public String handleExampleSudokuBoard(@RequestParam("grid") String grid, Model model)  {
        File file = new File("src/main/resources/sudoku/" + grid);
        try {
            model.addAttribute("sudoku", sudokuSolver.uploadExampleBoard(file));
        } catch (IOException e) {
            return "error";
        }
        model.addAttribute("fileName", grid.split("\\.")[0]);
        return "example";
    }


    @GetMapping("/home")
    public String handleHome() {
        return "index";
    }

    @GetMapping("/solver")
    public String handleSolver() {
        return "solver";
    }

    @GetMapping("/about")
    public String handleAbout() {
        return "about";
    }

    @GetMapping("/grid")
    public String handleUserGrid() {
        return "grid";
    }

    @GetMapping("/userGrid")
    public String handleManualGrid() {
        return "result";
    }
}
