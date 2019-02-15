package com.codecool.sudokusolver.controller;

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
import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;


@Controller
public class WebController {
    private ISudokuSolver sudokuSolver;

    @Autowired
    public WebController(ISudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }


    @PostMapping("/solver")
    public String handleSolvedSudoku(@RequestParam MultipartFile file, Model model) {
        SudokuResult sudokuResult;
        try {
            sudokuResult = sudokuSolver.solve(file);
        } catch (Exception e) {
            return "error";
        }
        model.addAttribute("solvedSudoku", sudokuResult.getSudoku());
        model.addAttribute("fileName", file.getName());
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

    @PostMapping("/userGrid")
    public String handleManualGrid(HttpEntity<String> request, Model model) {

        Gson g = new Gson();
        String json = request.getBody();
        System.out.println("JSON :" + json);
        int[] sudokuCells = g.fromJson(json, (Type) Array.class);

        System.out.println("\n\nSudoku: " + Arrays.toString(sudokuCells));
        SudokuResult sudokuResult;
        try {
            sudokuResult = sudokuSolver.solve(sudokuCells);
        } catch (Exception e) {
            return "error";
        }

        model.addAttribute("solvedSudoku", sudokuResult.getSudoku());
        model.addAttribute("time", sudokuResult.getElapsedTime());
        return "result";
    }


    @PostMapping("/example")
    public String handleExampleSudokuBoard(@RequestParam("grid") String grid, Model model)  {
        File file = new File("src/main/resources/sudoku/" + grid);
        try {
            model.addAttribute("sudoku", sudokuSolver.uploadExampleBoard(file));
        } catch (IOException e) {
            return "error";
        }
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
