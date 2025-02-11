package implementations.queue;


import java.util.Arrays;

public class FixedSizeQueue {
    private final int size;
    private final int[] array;
    private int currentIndex = -1;

    public FixedSizeQueue(int size) {
        this.size = size;
        array = new int[size];
    }

    public int size() {
        return size;
    }

    public void display() {
        Arrays.stream(array).forEach(data -> System.out.print(data + " "));
        System.out.println();
    }

    public void enQueue(int data) {
        array[++currentIndex] = data;
    }

    public int getCurrentIndex() {
        return currentIndex;
    }

    public void deQueue() {
        if (currentIndex == -1) return;
        int tempCounter = 1;
        int temp = array[tempCounter];
        while (tempCounter <= currentIndex + 1) {
            array[tempCounter - 1] = temp;
            tempCounter++;
            temp = array[tempCounter];

        }
        currentIndex--;
    }

    public int front(){
        return array[0];
    }

    public boolean isEmpty(){
        return currentIndex == -1;
    }

}
