package tdd;

import java.util.ArrayList;
import java.util.List;

public class MinMaxStackSimple implements MinMaxStack {

    private List<Integer> stack = new ArrayList<>();

    @Override
    public void push(int value) {
        stack.add(value);
    }

    @Override
    public int pop() {
        return 0;
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
