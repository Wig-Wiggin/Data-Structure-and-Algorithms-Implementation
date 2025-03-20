package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import implementations.queue.doubleEndedQueue.Deque;
import org.junit.jupiter.api.Test;

public class DequeTest {

    @Test
    public void testAddFirst() {
        Deque deque = new Deque(3);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.size());  // Size should be 3
        assertEquals(3, deque.peekFirst());  // First element should be 3
    }

    @Test
    public void testAddLast() {
        Deque deque = new Deque(3);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.size());  // Size should be 3
        assertEquals(3, deque.peekLast());  // Last element should be 3
    }

    @Test
    public void testRemoveFirst() {
        Deque deque = new Deque(3);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        int removed = deque.removeFirst();
        assertEquals(3, removed);  // Removed element should be 3
        assertEquals(2, deque.peekFirst());  // New front element should be 2
    }

    @Test
    public void testRemoveLast() {
        Deque deque = new Deque(3);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        int removed = deque.removeLast();
        assertEquals(3, removed);  // Removed element should be 3
        assertEquals(2, deque.peekLast());  // New last element should be 2
    }

    @Test
    public void testPeekFirst() {
        Deque deque = new Deque(3);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertEquals(3, deque.peekFirst());  // Peek first should return 3 without removing it
    }

    @Test
    public void testPeekLast() {
        Deque deque = new Deque(3);
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        assertEquals(3, deque.peekLast());  // Peek last should return 3 without removing it
    }

    @Test
    public void testIsEmpty() {
        Deque deque = new Deque(3);
        assertTrue(deque.isEmpty());  // Initially, deque should be empty
        deque.addFirst(1);
        assertFalse(deque.isEmpty());  // After adding, deque should not be empty
    }

    @Test
    public void testSize() {
        Deque deque = new Deque(3);
        assertEquals(0, deque.size());  // Initially, size should be 0
        deque.addFirst(1);
        assertEquals(1, deque.size());  // After adding one element, size should be 1
    }

    @Test
    public void testFullDeque() {
        Deque deque = new Deque(3);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        assertThrows(RuntimeException.class, () -> {
            deque.addFirst(4);  // Should throw exception because deque is full
        });
    }

    @Test
    public void testRemoveFromEmptyDeque() {
        Deque deque = new Deque(3);
        // Should throw exception because deque is empty
        assertThrows(RuntimeException.class, deque::removeFirst);
        // Should throw exception because deque is empty
        assertThrows(RuntimeException.class, deque::removeLast);
    }

    @Test
    public void testCapacityLimit() {
        Deque deque = new Deque(5);
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addFirst(5);
        assertEquals(5, deque.size());  // Deque should have 5 elements now
        assertThrows(RuntimeException.class, () -> {
            deque.addLast(6);  // Should throw exception because capacity is 5
        });
    }

    @Test
    public void testAlternatingAddRemove() {
        Deque deque = new Deque(5);
        deque.addFirst(1);
        deque.addLast(2);
        assertEquals(1, deque.removeFirst());  // Should remove 1
        assertEquals(2, deque.removeLast());   // Should remove 2
        assertTrue(deque.isEmpty());  // Deque should be empty now
    }

    @Test
    public void testStressTest() {
        Deque deque = new Deque(10000);

        // Add elements to the deque using addFirst and addLast alternately
        for (int i = 0; i < 5000; i++) {
            deque.addFirst(i);  // Add 0 to 4999 at the front
            deque.addLast(i + 5000);  // Add 5000 to 9999 at the back
        }
        //4999...,0,5000,...9999

        // Size should be 10000
        assertEquals(10000, deque.size());

        // Remove elements from the front (should be in reverse order from 4999 to 0)
        for (int i = 4999; i >= 0; i--) {
            assertEquals(i, deque.removeFirst()); // Removing from front, expected in reverse order of addFirst
        }

        // Remove elements from the back (should be in order from 5000 to 9999)
        for (int i = 9999; i >= 5000 ; i--) {

            assertEquals(i, deque.removeLast()); // Removing from back, expected in order of addLast
        }

        // Deque should be empty now
        assertTrue(deque.isEmpty());
    }



}
