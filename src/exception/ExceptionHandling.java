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

        logger.info("rest of the code");
    }
}
