package filehandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.logging.Logger;

public class IOJava {
    public static void main(String[] args) throws RuntimeException {
        Logger logger = Logger.getLogger(IOJava.class.getName());

        try(FileWriter fileWriter = new FileWriter("example.txt")){
            int i=1;
            while(i<=10) {
                fileWriter.write("Hello, is that clear\n");
                i++;
            }
        } catch (Exception e) {
            logger.info(String.valueOf(e));
        }

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("example.txt"))){
            String line;
            while((line=bufferedReader.readLine())!=null){
                System.out.println(line);
            }
        } catch (Exception e) {
            logger.info(String.valueOf(e));
        }
    }
}
