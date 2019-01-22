package com.codecool.sudokusolver.controller;

import com.codecool.sudokusolver.service.ISudokuSolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class WebController {
    private ISudokuSolver sudokuSolver;

    @Autowired
    public WebController(ISudokuSolver sudokuSolver) {
        this.sudokuSolver = sudokuSolver;
    }


    @PostMapping("/home")
    public String handlerSolvedSudoku(@RequestParam MultipartFile file, Model model) {
        model.addAttribute("solvedSudoku", sudokuSolver.solve(file));
        return "result";
    }

//    @GetMapping("/home")
//    public String handleHome() {
//
//    }
}
