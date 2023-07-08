package Domain;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IdGeneratorTest {

    @Test
    public void generateId(){
        int id = IdGenerator.getRandomInt();
        assertEquals(id, IdGenerator.randomInt());
        assertEquals(id+1, IdGenerator.randomInt());
        assertEquals(id+2, IdGenerator.randomInt());
        assertEquals(id+3, IdGenerator.randomInt());
    }
}
