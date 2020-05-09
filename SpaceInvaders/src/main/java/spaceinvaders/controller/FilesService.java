package spaceinvaders.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
/**
 * The class performs functionalities of shooting
 */
public class FilesService {

    private static final String FILENAME = "highScore.txt";

    public static void writeToFile(int score) {
        try {
            Path path = Paths.get(FILENAME);
            Files.write(path, String.valueOf(score).getBytes(), StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int readFromFile() {
        try {
            Path path = Paths.get(FILENAME);
            return Integer.valueOf(Files.lines(path).findFirst().get());
        } catch (IOException e) {
            return 0;
        }

    }
}
