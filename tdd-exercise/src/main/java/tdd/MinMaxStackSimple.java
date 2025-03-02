package tdd;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeMap;

public class MinMaxStackSimple implements MinMaxStack {

    private final LinkedList<Integer> stack = new LinkedList<>();
    private final TreeMap<Integer, Integer> orderedMap = new TreeMap<>();

    @Override
    public void push(int value) {
        stack.add(value);
        orderedMap.put(value, orderedMap.getOrDefault(value, 0) + 1);
    }

    @Override
    public int pop() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            int out = this.stack.removeLast();
            if (orderedMap.get(out) == 1) {
                orderedMap.remove(out);
            } else {
                orderedMap.put(out, orderedMap.get(out) - 1);
            }
            return out;
        }
    }

    @Override
    public int peek() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return this.stack.getLast();
        }
    }

    @Override
    public int getMin() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return orderedMap.firstKey();
        }
    }

    @Override
    public int getMax() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return orderedMap.lastKey();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.stack.isEmpty();
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
