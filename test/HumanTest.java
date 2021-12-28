import static org.junit.jupiter.api.Assertions.*;

import com.company.Human;
import org.junit.jupiter.api.*;

class HumanTest {

    Human testHuman;

    @BeforeEach
    void setUp() {
        testHuman = new Human("Human");
    }

    @Test
    void getName() {
        assertEquals("Human", testHuman.getName(), "Failure with getName method.");
    }

    @Test
    void setName() {
        testHuman.setName("Human");
        assertEquals("Human", testHuman.getName(), "Failure with setName method.");
    }

    @Test
    void getLevel() {
        assertEquals(1, testHuman.getLevel(), "Failure with getLevel method.");
    }

    @Test
    void setLevel() {
        testHuman.setLevel(1);
        assertEquals(1, testHuman.getLevel(),"Failure with setLevel method.");
    }

    @Test
    void getHealth() {
        testHuman.setName("Human");
        assertEquals("Human", testHuman.getName(), "Failure with getHealth method.");
    }

    @Test
    void setHealth() {
        testHuman.setHealth(100);
        assertEquals(100, testHuman.getHealth(), "Failure with setHealth method.");
    }

    @Test
    void getAttack() {
        assertEquals(8, testHuman.getAttack(), "Failure with getAttack method.");
    }

    @Test
    void setAttack() {
        testHuman.setAttack(8);
        assertEquals(8, testHuman.getAttack(), "Failure with setAttack method.");
    }

    @Test
    void testToString() {
        assertEquals("Human: { Name: Human, Level: 1, Health: 100, Attack: 8, Inventory: [Empty]}", testHuman.toString(), "Failure with toString method.");
    }
}