import com.codecool.sudokusolver.Service.FileParser;
import com.codecool.sudokusolver.Solving_algorithm;

import java.io.IOException;

public class App {

    public static void main(String[] args) {

        FileParser parser = new FileParser();

        try {
            Solving_algorithm solver = new Solving_algorithm(parser.parseFile("src/main/resources/sudoku/grid1.txt"));
            solver.printBoard();
            solver.solve();
            System.out.println("++++++++++++++++");
            solver.printBoard();
        } catch (IOException e) {
            e.printStackTrace();
        }





    }

}
