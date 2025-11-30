package exception;

public class CustomException extends Exception{
    public CustomException(String message){
        message = "kyo kar raha 0 se divide mat kar lala mat kar";
        super(message);
    }
}