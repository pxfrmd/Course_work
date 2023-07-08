package Commands;

import Exceptions.NoteException;

import java.util.logging.Logger;

public class CommandHelp implements CommandsHandler {
    public static final Logger LOGGER = Logger.getLogger(CommandHelp.class.getName());


    @Override
    public void handler() throws NoteException {
        LOGGER.fine("Вызвана команда {help}");
        Commands.printCommandsAndTitles();
    }
}
