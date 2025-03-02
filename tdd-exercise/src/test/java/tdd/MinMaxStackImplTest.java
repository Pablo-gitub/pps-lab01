package tdd;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

    @Test
    void getMinTest() {
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(1, stack.getMin());
    }

    @Test
    void getMaxTest() {
        stack.push(2);
        stack.push(3);
        stack.push(4);
        assertEquals(4, stack.getMax());
    }

    @Test
    void mixTest(){
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.pop();
        assertEquals(3, stack.getMax());
        stack.pop();
        assertEquals(2, stack.peek());
        stack.pop();
        Exception exception = assertThrows( IllegalStateException.class, () -> stack.getMax());
        assertEquals("Stack is empty", exception.getMessage());
        exception = assertThrows( IllegalStateException.class, () -> stack.getMin());
        assertEquals("Stack is empty", exception.getMessage());
    }

    @Test
    void unorderedStackTest() {
        stack.push(2);
        stack.push(3);
        stack.push(1);
        stack.push(2);
        assertEquals(3, stack.getMax());
        assertEquals(1, stack.getMin());
    }
}