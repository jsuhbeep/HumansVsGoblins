import static org.junit.jupiter.api.Assertions.*;

import com.company.Goblin;
import org.junit.jupiter.api.*;

class GoblinTest {
    Goblin testGoblin;

    @BeforeEach
    void setUp() {
        testGoblin = new Goblin("Goblin");
    }

    @Test
    void getName() {
        assertEquals("Goblin", testGoblin.getName(), "Failure with getName method.");
    }

    @Test
    void setName() {
        testGoblin.setName("Goblin");
        assertEquals("Goblin", testGoblin.getName(), "Failure with setName method.");
    }

    @Test
    void getHealth() {
        assertEquals(200, testGoblin.getHealth(), "Failure with getHealth method.");
    }

    @Test
    void setHealth() {
        testGoblin.setHealth(200);
        assertEquals(200, testGoblin.getHealth(), "Failure with setHealth method.");
    }

    @Test
    void getAttack() {
        assertEquals(5, testGoblin.getAttack(), "Failure with getAttack method.");
    }

    @Test
    void setAttack() {
        testGoblin.setAttack(5);
        assertEquals(5, testGoblin.getAttack(), "Failure with setAttack method.");
    }

    @Test
    void getLevel() {
        assertEquals(0, testGoblin.getLevel(), "Failure with getLevel method.");
    }

    @Test
    void setLevel() {
        testGoblin.setLevel(1);
        assertEquals(1, testGoblin.getLevel(), "Failure with setLevel method.");
    }

    @Test
    void testToString() {
        assertEquals("Goblin: { Name: Goblin, Level: 0, Health: 200, Attack: 5}", testGoblin.toString(), "Failure with toString method.");
    }
}