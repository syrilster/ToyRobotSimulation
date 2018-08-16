package exception;

public class GameException extends Exception {
    private String message;

    public GameException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage(){
        return message;
    }
}
