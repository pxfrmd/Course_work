package Domain;

import Exceptions.NoteException;

public class Checks {

    private Checks(){

    }
    public static boolean isTxtCorrect(String txt) throws NoteException {
        return txt.length() < 3;
    }
    public static boolean isLabelCorrect(String label) throws NoteException {
        return label.matches("^[a-zA-ZА-Яа-яЁё ]*$");
    }

    public static int isNumber(String str) {
        int num;
        try {
            num = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return -1;
        }
        return num;
    }

}
