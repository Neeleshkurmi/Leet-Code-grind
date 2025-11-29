package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandling {

    public static void main(String[] args) throws IOException {

        try (FileWriter fileWriter = new FileWriter("example.txt")) {
            fileWriter.write("hello");
            fileWriter.close();
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
