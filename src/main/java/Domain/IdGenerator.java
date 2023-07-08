package Domain;


public class IdGenerator {
    private static int randomInt = 1;
    public static int randomInt() {
        return randomInt++;
    }

    public static int getRandomInt() {
        return randomInt;
    }
}

