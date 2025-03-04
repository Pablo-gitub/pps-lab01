package tdd;

import java.util.LinkedList;

public class MinMaxStackSimple implements MinMaxStack {

    private final LinkedList<Integer> stack = new LinkedList<>();
    private final LinkedList<Integer> minStack = new LinkedList<>();
    private final LinkedList<Integer> maxStack = new LinkedList<>();

    @Override
    public void push(int value) {
        stack.add(value);
        if (minStack.isEmpty() || value <= minStack.getLast()) {
            minStack.add(value);
        } else {
            minStack.add(minStack.getLast());
        }

        if (maxStack.isEmpty() || value >= maxStack.getLast()) {
            maxStack.add(value);
        } else {
            maxStack.add(maxStack.getLast());
        }
    }

    @Override
    public int pop() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        minStack.removeLast();
        maxStack.removeLast();
        return stack.removeLast();
    }

    @Override
    public int peek() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack.getLast();
    }

    @Override
    public int getMin() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return minStack.getLast();
    }

    @Override
    public int getMax() {
        if (stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return maxStack.getLast();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public int size() {
        return stack.size();
    }
}
