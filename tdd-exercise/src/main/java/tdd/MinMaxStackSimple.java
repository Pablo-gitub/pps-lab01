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
        return 0;
    }

    @Override
    public int getMin() {
        return 0;
    }

    @Override
    public int getMax() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return this.stack.size();
    }
}
