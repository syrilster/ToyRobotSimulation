package command;

import exception.InvalidPositionException;

public interface Command {
    CommandResult execute() throws InvalidPositionException;
}
