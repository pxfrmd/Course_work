package Commands;

import Exceptions.NoteException;
import Domain.Note;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommandRemove implements CommandsHandler{

        private int isNumber(String str) {
            int num;
            try {
                num = Integer.parseInt(str);
            } catch (NumberFormatException e) {
                return -1;
            }
            return num;
        }
        private static final Logger LOGGER = Logger.getLogger(CommandRemove.class.getName());
        @Override
        public void handler() throws NoteException {
            Scanner sc = new Scanner(System.in);
            LOGGER.fine("Вызвана команда {note_remove}");
            System.out.print("Введите id удаляемой заметки: ");
            int idNone = isNumber(sc.nextLine());
            try {
                if (idNone == -1) {
                    throw new NoteException("Было введено не число");
                } else {
                    if (remover(idNone)) {
                        System.out.printf("Заметка с Id %d удалена\n", idNone);
                    } else {
                        System.out.printf("Заметка с Id %d не найдена\n", idNone);
                    }
                }
            } catch (NoteException e) {
                System.err.println(e.getMessage());
            }
        }

        private boolean remover(int idNote) {
            Iterator<Note> noteIterator = Note.noteList.iterator();
            while (noteIterator.hasNext()) {
                Note nextNote = noteIterator.next();
                if (nextNote.getId() == idNote) {
                    noteIterator.remove();
                    return true;
                }
            }
            return false;
        }
    }

