package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import implementations.queue.circularQueue.CircularQueue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CircularQueueTest {
    private CircularQueue queue;

    @BeforeEach
    public void setUp() {
        queue = new CircularQueue(5);  // Create a queue with capacity 5
    }

    @Test
    public void testEnqueueDequeue() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        assertEquals(1, queue.dequeue());
        assertEquals(2, queue.dequeue());
        assertEquals(3, queue.dequeue());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(queue.isEmpty());
        queue.enqueue(1);
        assertFalse(queue.isEmpty());
        queue.dequeue();
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testIsFull() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        assertTrue(queue.isFull());
        queue.dequeue();
        assertFalse(queue.isFull());
    }

    @Test
    public void testOverflow() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            queue.enqueue(6);  // Should throw Overflow error
        });
        assertEquals("Queue Overflow", exception.getMessage());
    }

    @Test
    public void testUnderflow() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            queue.dequeue();  // Should throw Underflow error
        });
        assertEquals("Queue Underflow", exception.getMessage());
    }

    @Test
    public void testCircularBehavior() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.dequeue();  // Remove 1
        queue.enqueue(4);  // Add 4
        queue.enqueue(5);  // Add 5

        assertEquals(2, queue.dequeue());  // Should return 2
        assertEquals(3, queue.dequeue());  // Should return 3
        assertEquals(4, queue.dequeue());  // Should return 4
        assertEquals(5, queue.dequeue());  // Should return 5
    }

    @Test
    public void testEdgeCase() {
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);  // Fill the queue
        assertEquals(1, queue.dequeue());  // Remove 1
        queue.enqueue(6);  // Add 6
        assertEquals(2, queue.dequeue());  // Remove 2
        assertEquals(3, queue.dequeue());  // Remove 3
        assertEquals(4, queue.dequeue());  // Remove 4
        assertEquals(5, queue.dequeue());  // Remove 5
        assertEquals(6, queue.dequeue());  // Remove 6

        // Now the queue should be empty
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testStressTest() {
        CircularQueue queue = new CircularQueue(1000); // Assuming a large capacity for stress test

        // Enqueue until the queue is full
        for (int i = 0; i < 1000; i++) {
            queue.enqueue(i);
        }
        assertEquals(1000, queue.size()); // Check that the queue is full

        // Dequeue half of the elements
        for (int i = 0; i < 500; i++) {
            queue.dequeue();
        }
        assertEquals(500, queue.size()); // After dequeueing, the size should be 500

        // Enqueue more elements to check circular behavior
        for (int i = 1000; i < 1500; i++) {
            queue.enqueue(i);
        }
        assertEquals(1000, queue.size()); // Queue should still have a size of 1000 (overwriting old values)

        // Dequeue all remaining elements
        for (int i = 0; i < 1000; i++) {
            queue.dequeue();
        }
        assertTrue(queue.isEmpty());
    }

    @Test
    public void testFront() {
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        assertEquals(10, queue.front());  // Front should be 10
    }
}
