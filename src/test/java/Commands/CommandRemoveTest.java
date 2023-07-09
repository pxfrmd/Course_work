package Commands;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CommandRemoveTest {
    @Test
    void isNumberPositiveTest() {
        String num = "5";
        assertEquals(5,CommandRemove.isNumber(num));
    }
    @Test
    void isNumberNegativeTest() {
        String testString = "g";
        assertEquals(-1, CommandRemove.isNumber(testString));
    }
}
