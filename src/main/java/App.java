import com.codecool.sudokusolver.Backtrack;
import com.codecool.sudokusolver.service.FileParser;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class App {

    public static void main(String[] args) {

        FileParser parser = new FileParser();

        try {

            File file = new File("src/main/resources/sudoku/grid1.txt");
            FileInputStream input = new FileInputStream(file);
            MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain", input);

            Backtrack solver = new Backtrack(parser);
            solver.solve(multipartFile);

        } catch (IOException e) {
            e.printStackTrace();
        }





    }

}
