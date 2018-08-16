package command;

public class CommandResult {
    private String message;

    public CommandResult(String messageFormat, Object... args) {
        this.message = String.format(messageFormat,args);
    }

    public String getMessage() {
        return message;
    }
}
