import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {
    Entity testEntity = new Warrior("Warrior", "Kleo", 100, 20, 10, 1);

    @Test
    void levelUpWithLessThan100Xp() {
        int level = testEntity.getLevel();
        testEntity.gainXP(99);
        int newLevel = testEntity.getLevel();
        assertEquals(1, level);
        assertEquals(1, newLevel);
    }

    @Test
    void levelUpWith100Xp() {
        int level = testEntity.getLevel();
        testEntity.gainXP(100);
        int newLevel = testEntity.getLevel();
        assertEquals(1, level);
        assertEquals(2, newLevel);
    }

    @Test
    void levelUpWithMoreThan100Xp() {
        int level = testEntity.getLevel();
        testEntity.gainXP(110);
        int newLevel = testEntity.getLevel();
        assertEquals(1, level);
        assertEquals(2, newLevel);
    }

    @Test
    void levelUpWithMoreThan200Xp() {
        int level = testEntity.getLevel();
        testEntity.gainXP(250);
        int newLevel = testEntity.getLevel();
        assertEquals(1, level);
        assertEquals(3, newLevel);
    }
}