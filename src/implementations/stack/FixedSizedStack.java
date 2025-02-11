package implementations.stack;

import java.util.Arrays;

public class FixedSizedStack {

    private int[] stack;
    private int index = -1;
    private final int capacity ;

    public FixedSizedStack(int size) {
        capacity = size;
        stack = new int[size];
    }

    public int getIndex(){
        return index;
    }

    public void push(int element) {
        if (index == capacity-1) throw new StackOverflowError("Stack is overflow.");

        stack[++index] = element;
    }

    public int pop() {

        if (index == -1) throw new StackUnderFlowException("Stack is underflow.");
        int poppedItem = stack[index];
        stack[index--] = 0;
        return poppedItem;
    }

    public void display() {
        Arrays.stream(stack).forEach(d -> System.out.print(d + " "));
        System.out.println();
    }

    public int top(){
        return  stack[index];
    }
    public int bottom(){
        return stack[0];
    }

    public int isEmpty(){
        return index == -1 ? 1 :0 ;
    }
    public int isFull(){
        return index == stack.length-1 ? 1 : 0;
    }
    public void deleteStack(){
      stack = new int[capacity];
    }
}
