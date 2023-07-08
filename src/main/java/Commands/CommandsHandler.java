package Commands;

import Exceptions.NoteException;

public interface CommandsHandler  {
    void handler() throws NoteException;
}
