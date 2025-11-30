package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHandling {

    public static void main(String[] args) throws IOException {

        try {
            Path path = Paths.get("Path.txt");
            Files.createFile(path);
            Files.write(path, new byte[]{0,0,0});
        }catch (Exception e) {
            e.printStackTrace();
        }

        FileReader fileReader = new FileReader("example.txt");
        try (BufferedReader br = new BufferedReader(fileReader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.print(line);
            }
        }
        fileReader.close();
    }
}
