package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.EmptyStackException;

import static org.junit.jupiter.api.Assertions.*;

class MinMaxStackImplTest {

    MinMaxStackSimple stack;

    @BeforeEach
    void setUp() {
        stack = new MinMaxStackSimple();
    }

    @Test
    void pushTest() {
        stack.push(1);
        assertEquals(1, stack.size());
    }

    @Test
    void popTest() {
        stack.push(2);
        assertEquals(2, stack.pop());
        assertEquals(0, stack.size());
    }

    @Test
    void peekTest() {
        stack.push(2);
        assertEquals(2, stack.peek());
    }

    @Test
    void peekEmptyStack() {
        Exception exception = assertThrows( IllegalStateException.class, () -> stack.peek());
        assertEquals("Stack is empty", exception.getMessage());
    }
}