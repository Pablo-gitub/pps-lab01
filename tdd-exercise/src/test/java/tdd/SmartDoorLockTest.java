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
    void lockTest(){
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            smartDoorLockSimple.lock();
        });
        assertEquals("pin is not set", exception.getMessage());
    }
}
