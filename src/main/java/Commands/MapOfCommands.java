package Commands;

import Exceptions.NoteException;

import java.util.HashMap;

public class MapOfCommands {

    private static final HashMap <Commands, CommandsHandler> mapOfCommands = new HashMap<>();

    static {
        CommandsHandler commandExit = new CommandExit();
        CommandsHandler commandExport = new CommandExport();
        CommandsHandler commandHelp = new CommandHelp();
        CommandsHandler commandList = new CommandList();
        CommandsHandler commandNewNote = new CommandNewNote();
        CommandsHandler commandRemove = new CommandRemove();

        mapOfCommands.put(Commands.EXIT, commandExit);
        mapOfCommands.put(Commands.NOTE_EXPORT, commandExport);
        mapOfCommands.put(Commands.HELP, commandHelp);
        mapOfCommands.put(Commands.NOTE_LIST, commandList);
        mapOfCommands.put(Commands.NOTE_NEW, commandNewNote);
        mapOfCommands.put(Commands.NOTE_REMOVE, commandRemove);
    }

    private static boolean commandIsPresent (String command) {
        try {
            Commands.valueOf(command);
            return true;
        } catch (NullPointerException | IllegalArgumentException e) {
            return false;
        }
    }

    public void startingUp (String command) throws NoteException {
        try {
            if(commandIsPresent(command)) {
                mapOfCommands.get(Commands.valueOf(command)).handler();
            } else {
                throw new NoteException("Команда не найдена!");
            }
        } catch ( NoteException e) {
            System.err.println(e.getMessage());
        }

        }
}
