package implementations.queue.priorityqueue;

public class Main {
    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        queue.display();

        queue.add(6);

        queue.add(4);

        queue.add(3);

        queue.add(1);

        queue.display();
    }
}
