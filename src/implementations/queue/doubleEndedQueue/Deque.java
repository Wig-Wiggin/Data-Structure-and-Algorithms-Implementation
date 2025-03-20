package implementations.queue.doubleEndedQueue;

public class Deque {
    int[] queue;
    int size;
    int capacity;
    int head;
    int tail;

    // Constructor
    public Deque(int capacity) {
        queue = new int[capacity];
        size = 0;
        this.capacity = capacity;
        head = 0;
        tail = 0;
    }

    // Add an element at the front of the deque
    public void addFirst(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }

        if (size == 0) {
            queue[0] = value;
            tail++;
            size++;
        } else if (head > 0) {
            head--;
            queue[head] = value;
            size++;
        } else if (tail != capacity) {
            for (int i = tail; i > head; i--) {
                queue[i] = queue[i-1];
            }
            queue[head] = value;
            tail++;
            size++;
        }



    }

    // Add an element at the end of the deque
    public void addLast(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }

        queue[tail] = value;
        tail++;
        size++;

    }

    // Remove and return the element at the front of the deque
    public int removeFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }

        int result = queue[head];
        queue[head] = 0;
        head++;
        size--;
        return result;


    }

    // Remove and return the element at the end of the deque
    public int removeLast() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underFlow");
        }

        int result = queue[tail - 1];
        tail--;
        size--;
        return result;


    }

    // Get the element at the front without removing it
    public int peekFirst() {

        return queue[head];

    }

    // Get the element at the end without removing it
    public int peekLast() {

        return queue[tail - 1];

    }

    // Check if the deque is empty
    public boolean isEmpty() {

        return size == 0; // Placeholder return
    }

    // Get the size of the deque
    public int size() {

        return size; // Placeholder return
    }

    public boolean isFull() {
        return size == capacity;
    }

    // Print the elements of the deque
    public void printDeque() {
        // Implement the method to print the deque
    }
}
