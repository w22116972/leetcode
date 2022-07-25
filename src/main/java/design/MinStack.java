package design;

import java.util.LinkedList;

public class MinStack {

    private final LinkedList<Integer> minStack;
    private final LinkedList<Integer> stack;

    public MinStack() {
        this.minStack = new LinkedList<>();
        this.stack = new LinkedList<>();
    }

    public void push(int val) {
        this.stack.addLast(val);
        if (this.minStack.isEmpty() || val < this.minStack.getLast()) {
            this.minStack.addLast(val);
        } else {
            this.minStack.addLast(this.minStack.getLast());
        }
    }

    public void pop() {
        this.stack.removeLast();
        this.minStack.removeLast();
    }

    public int top() {
        return this.stack.getLast();
    }

    public int getMin() {
        return this.minStack.getLast();
    }
}
