package Commands;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public enum Commands {
    HELP ("Выводит на экран список доступных команд с их описанием"),
    NOTE_NEW ("Cоздать новую заметку"),
    NOTE_LIST ("Выводит все заметки на экран"),
    NOTE_REMOVE ("Удаляет заметку"),
    NOTE_EXPORT ("Сохраняет все заметки в текстовый файл и выводит имя сохраненного файла"),
    EXIT ("Выход из приложения");

    private String title;

    @Override
    public String toString() {
        return this.name();
    }

    public static void printCommands(){
        for (Commands command:
             Commands.values()) {
            System.out.println(command.toString().toLowerCase());
        }
    }
    
    public static void printCommandsAndTitles(){
        for (Commands command:
             Commands.values()) {
            System.out.println(command.toString().toLowerCase() + ": " + command.title);
        }
    }
}
