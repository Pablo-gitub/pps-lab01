package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SmartDoorLockTest {

    private SmartDoorLockSimple smartDoorLockSimple;

    @BeforeEach
    void beforeEach() {
        smartDoorLockSimple = new SmartDoorLockSimple();
    }

    @Test
    void setPinTest(){
        smartDoorLockSimple.setPin(3333);
    }

    @Test
    void setInvalidPinTest(){
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            smartDoorLockSimple.setPin(333);
        });
        assertEquals("Error Pin Length", exception.getMessage());
    }

    @Test
    void setInvalidLongPinTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            smartDoorLockSimple.setPin(12345);
        });
        assertEquals("Error Pin Length", exception.getMessage());
    }

    @Test
    void unlockTest(){
        smartDoorLockSimple.setPin(3333);
        smartDoorLockSimple.unlock(3333);
    }

    @Test
    void lockTestException(){
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            smartDoorLockSimple.lock();
        });
        assertEquals("pin is not set", exception.getMessage());
    }

    @Test
    void lockTest(){
        smartDoorLockSimple.setPin(3333);
        smartDoorLockSimple.lock();
        assertTrue(smartDoorLockSimple.isLocked());
    }

    @Test
    void getMaxAttemptsTest(){
        smartDoorLockSimple.setPin(3333);
        smartDoorLockSimple.lock();
        smartDoorLockSimple.unlock(3332);
        assertEquals(2, smartDoorLockSimple.getMaxAttempts());
        assertEquals(1, smartDoorLockSimple.getFailedAttempts());
    }

    @Test
    void blockTest(){
        smartDoorLockSimple.setPin(3333);
        smartDoorLockSimple.lock();
        smartDoorLockSimple.unlock(3332);
        assertEquals(2, smartDoorLockSimple.getMaxAttempts());
        assertEquals(1, smartDoorLockSimple.getFailedAttempts());
        smartDoorLockSimple.unlock(3332);
        assertEquals(1, smartDoorLockSimple.getMaxAttempts());
        assertEquals(2, smartDoorLockSimple.getFailedAttempts());
        smartDoorLockSimple.unlock(3332);
        assertEquals(0, smartDoorLockSimple.getMaxAttempts());
        assertEquals(3, smartDoorLockSimple.getFailedAttempts());
        assertTrue(smartDoorLockSimple.isBlocked());
    }

    @Test
    void unlockWithMistakePinsTest(){
        smartDoorLockSimple.setPin(3333);
        smartDoorLockSimple.lock();
        smartDoorLockSimple.unlock(3332);
        assertEquals(2, smartDoorLockSimple.getMaxAttempts());
        assertEquals(1, smartDoorLockSimple.getFailedAttempts());
        smartDoorLockSimple.unlock(3332);
        assertEquals(1, smartDoorLockSimple.getMaxAttempts());
        assertEquals(2, smartDoorLockSimple.getFailedAttempts());
        smartDoorLockSimple.unlock(3333);
        assertFalse(smartDoorLockSimple.isLocked());
    }

    @Test
    void resetTest(){
        smartDoorLockSimple.setPin(3333);
        smartDoorLockSimple.lock();
        smartDoorLockSimple.unlock(3332);
        smartDoorLockSimple.unlock(3332);
        smartDoorLockSimple.unlock(3332);
        smartDoorLockSimple.reset();
        assertFalse(smartDoorLockSimple.isLocked());
        assertFalse(smartDoorLockSimple.isBlocked());
    }
}
