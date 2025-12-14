package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class InputAndOutput {
    public static void main(String[] args) throws Exception{
        File file = new File("example.txt");
        try (FileWriter fileWriter = new FileWriter(file, true);
             BufferedReader reader = new BufferedReader(new FileReader(file))){

            fileWriter.write("abcd");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
