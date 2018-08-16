package exception;

public class InvalidPositionException extends Exception {
    private String message;

    public InvalidPositionException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
