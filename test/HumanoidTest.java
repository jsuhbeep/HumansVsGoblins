import static org.junit.jupiter.api.Assertions.*;

import com.company.Humanoid;
import org.junit.jupiter.api.*;

class HumanoidTest {
    Humanoid testHumanoid;

    @BeforeEach
    void setUp() {
        testHumanoid = new Humanoid();
    }

    @Test
    void getName() {
        assertEquals(null, testHumanoid.getName());
    }

    @Test
    void setName() {
        testHumanoid.setName("Humanoid");
        assertEquals("Humanoid", testHumanoid.getName());
    }

    @Test
    void getHealth() {
        assertEquals(0, testHumanoid.getHealth());
    }

    @Test
    void setHealth() {
        testHumanoid.setHealth(1);
        assertEquals(1, testHumanoid.getHealth());
    }

    @Test
    void getAttack() {
        assertEquals(0, testHumanoid.getAttack());
    }

    @Test
    void setAttack() {
        testHumanoid.setAttack(1);
        assertEquals(1, testHumanoid.getAttack());
    }


    @Test
    void getLevel() {
        assertEquals(0, testHumanoid.getLevel());
    }

    @Test
    void setLevel() {
        testHumanoid.setLevel(1);
        assertEquals(1, testHumanoid.getLevel());
    }
}