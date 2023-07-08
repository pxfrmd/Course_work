package Commands;

import Exceptions.NoteException;
import java.util.logging.Logger;

public class CommandExit implements CommandsHandler{
    public static final Logger LOGGER = Logger.getLogger(CommandExit.class.getName());

    @Override
    public void handler() throws NoteException {
        LOGGER.fine("Вызвана команда {exit}");
        System.exit(0);
    }
}
