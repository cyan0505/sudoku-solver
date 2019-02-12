import com.codecool.sudokusolver.model.Sudoku;
import com.codecool.sudokusolver.model.SudokuSolverManager;
import com.codecool.sudokusolver.service.FileParser;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Files;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class App {

    public static void main(String[] args) throws Exception {

        FileParser parser = new FileParser();
//        File file = new File("/home/bartosz/Codecool/Advanced/sudoku-solver/worlds_hardest_sudoku.txt");
        File file = new File("/home/bartosz/Codecool/Advanced/sudoku-solver/grid1.txt");
//        File file = new File("/home/bartosz/Codecool/Advanced/sudoku-solver/grid2.txt");
//        File file = new File("/home/bartosz/Codecool/Advanced/sudoku-solver/grid3.txt");
//        File file = new File("/home/bartosz/Codecool/Advanced/sudoku-solver/grid4.txt");

        MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", Files.readAllBytes(file.toPath()));
        Sudoku sudoku = new Sudoku(parser.parseFile(multipartFile));
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Sudoku> solvedSudoku = executorService.submit(new SudokuSolverManager(sudoku));
        long starttime = System.currentTimeMillis();
        Sudoku solved = solvedSudoku.get();
        long endtime = System.currentTimeMillis();
        System.out.println(endtime - starttime);
        System.out.println(solved);
    }
}
