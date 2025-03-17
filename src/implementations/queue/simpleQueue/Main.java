package implementations.queue.simpleQueue;

public class Main {
    public static void main(String[] args) {
        FixedSizeQueue queue = new FixedSizeQueue(10);
        for (int i = 1; i<= 5; i++){
            queue.enQueue(i);
        }
        queue.display();

       for (int i = 1;i<=10;i++){
           queue.deQueue();
           queue.display();
       }
    }
}
