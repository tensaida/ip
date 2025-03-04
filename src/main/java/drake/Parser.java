package drake;

import drake.commands.ByeCommand;
import drake.commands.Command;
import drake.commands.DeadlineCommand;
import drake.commands.DeleteCommand;
import drake.commands.EventCommand;
import drake.commands.FindCommand;
import drake.commands.ListCommand;
import drake.commands.MarkCommand;
import drake.commands.TodoCommand;
import drake.commands.UnmarkCommand;
import drake.commands.WithinCommand;

/**
 * Command parser.
 */
public class Parser {

    /**
     * Parses and executes the given input using the given module instances.
     * @param fullInput The input given to the bot.
     * @return The Command parsed from the user input.
     */
    public static Command parse(String fullInput) throws UnknownCommandException,
            IncompatibleCommandException, EmptyDescriptionException {
        int firstSpace = fullInput.indexOf(' ');
        String commandText;
        if (fullInput.matches("list|bye")) {
            commandText = fullInput;
        } else if (firstSpace == -1 && fullInput.matches("deadline|event|todo")) {
            throw new EmptyDescriptionException();
        } else if (firstSpace == -1) {
            throw new UnknownCommandException();
        } else {
            commandText = fullInput.substring(0, firstSpace);
        }
        switch (commandText) {
        case "list":
            return new ListCommand();
        case "mark":
            return new MarkCommand(fullInput);
        case "unmark":
            return new UnmarkCommand(fullInput);
        case "todo":
            return new TodoCommand(fullInput);
        case "deadline":
            return new DeadlineCommand(fullInput);
        case "event":
            return new EventCommand(fullInput);
        case "delete":
            return new DeleteCommand(fullInput);
        case "bye":
            return new ByeCommand();
        case "find":
            return new FindCommand(fullInput);
        case "within":
            return new WithinCommand(fullInput);
        default:
            throw new UnknownCommandException();
        }
    }
}
