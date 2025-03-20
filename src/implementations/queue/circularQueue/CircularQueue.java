package implementations.queue.circularQueue;


public class CircularQueue {
    private final int[] queue;
    private int front;
    private int rear;
    private int size;
    private final int capacity;

    // Constructor to initialize the queue
    public CircularQueue(int capacity) {

        queue = new int[capacity];
        front = 0;
        rear = 0;
        size = 0;
        this.capacity = capacity;
    }

    // Enqueue operation
    public void enqueue(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue Overflow");
        }

        if(rear == capacity){
            rear = 0;
        }
        queue[rear] = value;
        rear++;
        size++;


    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue Underflow");
        }

        int result = queue[front];
        if(front == capacity-1){
            front = 0;
        }else {
            front++;
        }
        size--;
        return result;

    }

    // Get the front element of the queue
    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        return queue[front]; // return -1 if queue is empty
    }

    // Get the rear element of the queue
    public int rear() {
        if (size != 0) {
            return queue[rear];
        }
        return -1; // return -1 if queue is empty
    }

    // Check if the queue is empty
    public boolean isEmpty() {

        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {

        return size == capacity;
    }

    // Print the elements in the queue (for debugging)
    public void printQueue() {
        int start = rear;
        while (start != front) {
            if (start == capacity - 1) {
                start = 0;
            }
            System.out.print(queue[start]);
            start++;
        }
    }

    public int size() {
        return size;
    }
}
