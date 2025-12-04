package exception;

import java.util.logging.Logger;

public class ExceptionHandling {
    public static void main(String[] args) throws CustomException {
        Logger logger = Logger.getLogger(ExceptionHandling.class.getName());

        try {
            int a = 2/0;
        } catch (Exception e) {
            logger.info(String.valueOf(e));
        }
        int age = 14;
        System.out.println("The voter's age is");
        System.out.println();
    }
}
