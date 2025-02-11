package implementations.stack;

import java.util.Arrays;

public class FixedSizeStack_Beta {

    private final int[] stack;
    private int pointer;

    public FixedSizeStack_Beta(int size) {
        stack = new int[size];
    }

    public void push(int element) {
        if (pointer == stack.length) throw new StackOverflowError("Stack is overflow.");

        stack[pointer++] = element;
    }

    public int pop() {

        if (pointer < 0) throw new StackUnderFlowException("Stack is underflow.");
        if (pointer == stack.length) pointer--;
        stack[pointer] = 0;
        if (pointer != 0) pointer--;

        return stack[pointer];
    }

    public void display() {
        Arrays.stream(stack).forEach(d -> System.out.print(d + " "));
        System.out.println();
    }

    public int top(){
        int temp = pointer;
        return pointer == stack.length ? stack[--temp] : stack[pointer];
    }
    public int bottom(){
        return stack[0];
    }

    public int isEmpty(){
        return pointer == 0 && stack[0] == 0 ? 1 : 0;
    }
    public int isFull(){
        return pointer == stack.length ? 1 : 0;
    }

}
