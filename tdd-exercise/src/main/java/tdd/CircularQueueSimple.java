package tdd;

import java.util.LinkedList;

public class CircularQueueSimple implements CircularQueue{
    private final int capacity;
    private final LinkedList<Integer> queue = new LinkedList<>();
    private int oldestIndex;

    public CircularQueueSimple(int capacity) {
        this.capacity = capacity;
        oldestIndex = 0;
    }


    @Override
    public void push(int value) {
        if (queue.size() == capacity) {
            queue.remove(oldestIndex);
            queue.add(oldestIndex, value);
            if (oldestIndex >= capacity - 1) {
                oldestIndex = 0;
            } else {
                oldestIndex ++;
            }
        } else {
            queue.add(value);
        }
    }

    @Override
    public int pop() {
        if (queue.isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        } else {
            if(oldestIndex >= queue.size()) {
                oldestIndex = 0;
            }
            return this.queue.remove(oldestIndex);
        }
    }
}
