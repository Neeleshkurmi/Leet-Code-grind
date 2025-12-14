package filehandling;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class InputAndOutput {
    public static void main(String[] args) throws Exception{
        File file = new File("example.txt");
        FileWriter fileWriter = new FileWriter(file, true);

        fileWriter.write("abcd");

//        FileReader fileReader = new FileReader(file);
//        String line;
//        while(fileReader.read()!=-1){
//            System.out.print((char) (fileReader.read()));
//        }
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line=reader.readLine())!=null){
            System.out.println(line);
        }
    }
}
