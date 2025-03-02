package tdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    CircularQueueSimple queue;

    @Test
    void initializingTest(){
        queue = new CircularQueueSimple(4);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        assertEquals(1, queue.pop());
        assertEquals(2, queue.pop());
        queue.push(5);
        queue.push(6);
        queue.push(7);
        assertEquals(4, queue.pop());
        assertEquals(5, queue.pop());
        assertEquals(6, queue.pop());
        assertEquals(7, queue.pop());
        Exception exception = assertThrows( IllegalStateException.class, ()->{
            queue.pop();
        });
        assertEquals("Queue is empty", exception.getMessage());
    }
}
