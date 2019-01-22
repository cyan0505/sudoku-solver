package com.codecool.sudokusolver.controller;

import com.codecool.sudokusolver.service.ISudokuSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class WebController {
    private ISudokuSolver sudokuSolver;

    @Autowired
    public WebController(ISudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }


    @PostMapping("/solver")
    public String handleSolvedSudoku(@RequestParam MultipartFile file, Model model) throws IOException {
        model.addAttribute("sudokuBoard", sudokuSolver.solve(file));
        return "result";
    }


//    @PostMapping("/solver")
//    public String handleUploadFile(@RequestParam MultipartFile file, Model model) throws IOException {
//        model.addAttribute("sudoku", );
//        return "sudoku";
//    }


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


}
