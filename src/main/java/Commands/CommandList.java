package Commands;
import Domain.Note;
import Exceptions.NoteException;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class CommandList implements CommandsHandler{

    public static final Logger LOGGER = Logger.getLogger(CommandList.class.getName());

    @Override
    public void handler() throws NoteException {
        LOGGER.fine("Вызвана команда {note_list}");

        System.out.println("Введите метки, чтобы отобразить определенные заметки");
        System.out.println("или оставьте пустым для отображения всех заметок.");

        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine().toUpperCase().trim();

        if (userInput.isBlank()) {
            printNotes(Note.noteList);
        } else {
            try {
                String[] arrStringInput = userInput.split(" ");
                if (findNote(arrStringInput).isEmpty()) {
                    throw new NoteException("Заметки не найдены.");
                } else {
                    printNotes(findNote(arrStringInput));
                }
            } catch (NoteException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String printNotes(List<Note> list) {

        StringBuilder sb = new StringBuilder();
        for (Note note : list) {
            sb.append(note.toString());
            System.out.println(note);
        }
        return sb.toString();
    }

    private List<Note> findNote(String[] input) {
        List<Note> list = new ArrayList<>();
        for (String s : input) {
            for (Note note : Note.noteList) {
                if (note.getLabel().contains(s)) {
                    list.add(note);
                }
            }
        }
        return list;
    }
}

