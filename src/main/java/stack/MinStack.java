package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 *
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStack {

    Deque<Integer> stack = new LinkedList<>();
    Deque<Integer> minStack = new LinkedList<>();

    public MinStack() {}

    public void push(int x) {
        stack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else if (x <= minStack.getFirst()) {
                minStack.push(x);
        }
    }

    public void pop() {
        int x = stack.pop();
        if (!minStack.isEmpty() && minStack.getFirst() == x) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.getFirst();
    }

    public int getMin() {
        return minStack.getFirst();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(0);
        minStack.push(1);
        minStack.push(0);
        System.out.println(minStack.stack);
        System.out.println(minStack.minStack);
        System.out.println(minStack.getMin());//   --> Returns -3.
        minStack.pop();
        System.out.println(minStack.top());//      --> Returns 0.
        System.out.println(minStack.getMin());//   --> Returns -2.
    }
}
