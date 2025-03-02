package tdd;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MinMaxStackSimple implements MinMaxStack {

    private final LinkedList<Integer> stack = new LinkedList<>();

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        int out = this.stack.getLast();
        this.stack.removeLast();
        return out;
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
            return this.stack.stream().min(Integer::compare).get();
        }
    }

    @Override
    public int getMax() {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        } else {
            return this.stack.stream().max(Integer::compare).get();
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
