package Commands;

import Domain.Note;
import Exceptions.NoteException;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CommandNewNoteTest {
    @Test
    void txtIslongerThanThreeSymbols() throws Exception {
        String testString = "ABCDEFG";
        assertTrue(CommandNewNote.isTxtCorrect(testString));
    }

    @Test
    void txtIsShorterThanThreeSymbols() throws Exception {
        String testString = "abc";
        assertFalse(CommandNewNote.isTxtCorrect(testString));
    }
    @Test
    void labelContainsOnlyLetters() throws Exception {
        String correctLabel = "sdsdf";
        assertTrue(CommandNewNote.isLabelCorrect(correctLabel));
    }
    @Test
    void labelContainsLettersAndNumbers() throws Exception {
        String wrongLabel = "adsf1";
        assertFalse(CommandNewNote.isLabelCorrect(wrongLabel));
    }


    private Note newNote;

    @BeforeEach
    void setUp(){
        Note.noteList.clear();
    }

    @Test
    void newNoteWithAllDataAdded() throws Exception {
        List<String> labels = Arrays.asList("Делай", "РАЗ");
        ByteArrayInputStream in = new ByteArrayInputStream(("Я текст заметки" + "\n" + StringUtils.join(labels," ") + "\n").getBytes());
        System.setIn(in);
        CommandsHandler newNote = new CommandNewNote();
        newNote.handler();
        assertEquals(1, Note.noteList.size());
        assertEquals("Я текст заметки", Note.noteList.get(0).getNoteText());
    }
    @Test
    void newNoteTooShortNotAdded() throws Exception {
        CommandsHandler newNote = new CommandNewNote();
        List<String> labels = Arrays.asList("Делай", "РАЗ");
        try {
            ByteArrayInputStream in = new ByteArrayInputStream(("Я" + "\n" + StringUtils.join(labels," ") + "\n").getBytes());
            System.setIn(in);
        } catch (Exception e) {
            assertThrows(NoteException.class, newNote::handler);
            assertEquals("Введенная заметка не может быть короче трех символов!", e.getMessage());
        }
    }

    @Test
    void newNoteWithEmptyLabelAdded() throws NoteException {
        CommandNewNote newNote = new CommandNewNote();
        List <String> labels = Arrays.asList(" ", " ");
        ByteArrayInputStream in = new ByteArrayInputStream(("Я текст заметки" + "\n" + StringUtils.join(labels," ") + "\n").getBytes());
        System.setIn(in);
        newNote.handler();
        assertTrue(Note.noteList.get(0).getLabel().get(0).isEmpty());
        assertEquals("Я текст заметки", Note.noteList.get(0).getNoteText());
    }

    @Test
    void noteWithWrongLabelNotAdded (){
        CommandNewNote newNote = new CommandNewNote();
        List <String> labels = Arrays.asList("123", "456");
        try{
            ByteArrayInputStream in = new ByteArrayInputStream(("Я текст заметки" + "\n" + StringUtils.join(labels," ") + "\n").getBytes());
            System.setIn(in);
        } catch (Exception e) {
            assertThrows(NoteException.class, newNote::handler);
            assertEquals("Метка может содержать только буквы!", e.getMessage());
        }
    }
}
