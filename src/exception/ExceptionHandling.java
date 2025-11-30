package exception;

import java.util.logging.Logger;

public class ExceptionHandling {
    public static void main(String[] args) throws CustomException {
        Logger logger = Logger.getLogger(ExceptionHandling.class.getName());

        try {
            int a = 2/0;
        } catch (Exception e) {
            throw new CustomException(String.valueOf(e));
        }
    }
}
