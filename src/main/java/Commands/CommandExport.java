package Commands;


import Domain.Note;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;


public class CommandExport implements CommandsHandler {
        public static final Logger LOGGER = Logger.getLogger(CommandExport.class.getName());
        @Override
        public void handler() {
            LOGGER.fine("Вызвана команда {note_export}");

            FileWriter fw = null;
            try {
                fw = new FileWriter(setFilename(), false);
                for (Note note : Note.noteList) {
                    fw.write(note.toString());
                }
                fw.flush();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            } finally {
                try {
                    if (fw != null) {
                        fw.close();
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        private String setFilename() {
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd_HH-mm-ss");
            return "note_" + sdf.format(date) + ".txt";
        }
}

