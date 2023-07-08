package Domain;

import Commands.*;
import Exceptions.NoteException;


import java.util.Scanner;

public class ConsoleReader {
    public static void consoleReader() throws NoteException {
        System.out.println("Список доступных команд:");
        Commands.printCommands();
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Введите команду:");
            String userCommand = sc.nextLine().toUpperCase().trim();
            new MapOfCommands().startingUp(userCommand);
        }

    }
}
