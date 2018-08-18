package validator;

import exception.InvalidCommandException;
import models.SimulationCommand;

import java.util.Arrays;

import static exception.ExceptionConstants.INCOMPLETE_COMMAND_ARGUMENTS;
import static exception.ExceptionConstants.INVALID_COMMAND_MESSAGE;

public class CommandValidator {

    public static SimulationCommand validateAndGetInputCommand(String command) throws InvalidCommandException {
        SimulationCommand result = Arrays.stream(SimulationCommand.values())
                .filter(e -> e.name().equalsIgnoreCase(command)).findAny().orElse(null);
        if (result == null)
            throw new InvalidCommandException(INVALID_COMMAND_MESSAGE);
        return result;
    }

    public static boolean validatePlaceCommand(String[] arguments) throws InvalidCommandException {
        if (arguments.length < 2) {
            throw new InvalidCommandException(INCOMPLETE_COMMAND_ARGUMENTS);
        } else {
            String[] placeCommandParams = arguments[1].split(",");
            try {
                if (!placeCommandParams[0].isEmpty() && !placeCommandParams[1].isEmpty() && !placeCommandParams[2].isEmpty())
                    return true;
            } catch (ArrayIndexOutOfBoundsException exception) {
                throw new InvalidCommandException(INCOMPLETE_COMMAND_ARGUMENTS);
            }
        }
        return true;
    }

    public static boolean isInputCommandPlace(SimulationCommand command) {
        return command == SimulationCommand.PLACE;
    }
}
