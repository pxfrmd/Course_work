package Domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter

public class Note {
    private final int id;
    private final String noteText;
    private final List<String> label;

    public static List<Note> noteList = new ArrayList<>();

    public Note(String noteText, List<String> label){
        this.id = IdGenerator.randomInt();
        this.noteText = noteText;
        this.label = label;
    }

    @Override
    public String toString() {
        return "{" + id + "}" + "#" + "{" + this.getNoteText() + "}" + "\n" + this.getLabel();
    }


}


