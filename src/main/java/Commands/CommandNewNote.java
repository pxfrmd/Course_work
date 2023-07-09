package Commands;

import Domain.Note;
import Exceptions.NoteException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Logger;

import static Domain.Note.noteList;


public class CommandNewNote implements CommandsHandler {
    public static final Logger LOGGER = Logger.getLogger(CommandNewNote.class.getName());


    public static boolean isTxtCorrect(String txt) throws NoteException {
        return txt.length() < 3;
    }
    public static boolean isLabelCorrect(String label) throws NoteException {
        return label.matches("^[a-zA-ZА-Яа-яЁё ]*$");
    }


    @Override
    public void handler() throws NoteException {
        LOGGER.fine("Вызвана команда {new_note}");

        try {
            System.out.println("Введите текст:");
            Scanner sc = new Scanner(System.in);
            String noteTxt = sc.nextLine().trim();

            if(this.isTxtCorrect(noteTxt)) {
                LOGGER.info("Текст заметки должен быть длиннее 3 символов, введено - {" + noteTxt + "}");
                throw new NoteException("Введенная заметка не может быть короче трех символов!");
            }

            System.out.println("Добавить метку? Метка должна состоять из букв.");
            System.out.println("Можно добавить несколько, слова должны быть разделены пробелом.");
            String labelTxt = sc.nextLine().toUpperCase().trim();

            if (!this.isLabelCorrect(labelTxt)) {
                LOGGER.info("Метки должны содержать только буквы, введено - {" + labelTxt + "}");
                throw new NoteException("Метка может содержать только буквы!");
            }
            noteList.add(new Note(noteTxt, Arrays.stream(labelTxt.split(" ")).toList()));
            System.out.println("Заметка успешно добавлена!");

        } catch (NoteException e) {
            System.err.println(e.getMessage());
        }

    }
}
