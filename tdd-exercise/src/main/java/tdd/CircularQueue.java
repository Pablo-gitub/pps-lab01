package tdd;

/**
 *  Task 3 - TDD for Circular Queue
 *  A simple CircularQueue that stores integers with a **fixed** capacity.
 *  When full, new elements overwrite the oldest ones.
 *  
 *  When removing elements, the oldest ones are removed first.
 *  Therefore, giving [4, 5, 3], the first element to be removed is 4, then 5, and finally 3.
 *  
 *  For the exercise: 
 *   - Think about the test cases you need to write.
 *   - Introduce methods in the interface in order to make the tests pass.
 *   - Refactor
 */
public interface CircularQueue {
    /**
     * insert a value to the circular queue
     * if the length of the queue is higher than the fixed capacity
     * overwrite the oldest element
     * @param value new element fo the queue
     */
    void push(int value);

    /**
     * return and delete the oldest element in the queue
     * @return the oldest element
     */
    int pop();

}