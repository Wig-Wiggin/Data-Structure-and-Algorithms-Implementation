package test.dataStructures;

import implementations.linkedList.circularLinkedList.CircularLinkedList;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularLinkedListTest {

    @Test
    void testAddFirst() {
        CircularLinkedList list = new CircularLinkedList();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);

        assertEquals(3, list.size());
        assertTrue(list.search(10));
        assertTrue(list.search(20));
        assertTrue(list.search(30));
    }

    @Test
    void testAddLast() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(5);
        list.addLast(15);
        list.addLast(25);

        assertEquals(3, list.size());
        assertTrue(list.search(5));
        assertTrue(list.search(15));
        assertTrue(list.search(25));
    }

    @Test
    void testInsertAt() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(40);
        list.insertAt(2, 30); // Insert at index 2

        assertEquals(4, list.size());
        assertTrue(list.search(30));
    }

    @Test
    void testRemoveFirst() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(100);
        list.addLast(200);
        list.addLast(300);
        list.removeFirst();

        assertEquals(2, list.size());
        assertFalse(list.search(100));
    }

    @Test
    void testRemoveLast() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.removeLast();

        assertEquals(2, list.size());
        assertFalse(list.search(3));
    }

    @Test
    void testRemoveAt() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        list.addLast(40);
        list.removeAt(1); // Remove second element

        assertEquals(3, list.size());
        assertFalse(list.search(20));
    }

    @Test
    void testCircularProperty() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);

        // Get last node and check if it points to head
        CircularLinkedList.Node lastNode = list.getTail();
        assertNotNull(lastNode);
        assertEquals(list.getHead(), lastNode.next);
    }

    @Test
    void testIsEmpty() {
        CircularLinkedList list = new CircularLinkedList();
        assertTrue(list.isEmpty());

        list.addLast(99);
        assertFalse(list.isEmpty());

        list.removeFirst();
        assertTrue(list.isEmpty());
    }

    @Test
    void testSize() {
        CircularLinkedList list = new CircularLinkedList();
        assertEquals(0, list.size());

        list.addLast(10);
        list.addLast(20);
        list.addLast(30);
        assertEquals(3, list.size());

        list.removeFirst();
        assertEquals(2, list.size());

        list.removeLast();
        assertEquals(1, list.size());
    }

    @Test
    void testSearch() {
        CircularLinkedList list = new CircularLinkedList();
        list.addLast(11);
        list.addLast(22);
        list.addLast(33);

        assertTrue(list.search(22));
        assertFalse(list.search(99));
    }

    @Test
    void testEdgeCases() {
        CircularLinkedList list = new CircularLinkedList();

        // Remove from empty list
        list.removeFirst();
        list.removeLast();
        list.removeAt(0);

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());

        // Insert at invalid position
        list.insertAt(-1, 100);
        list.insertAt(5, 200); // Beyond bounds

        assertEquals(0, list.size()); // List should still be empty
    }

    @Test
    void testStressTest() {
        CircularLinkedList list = new CircularLinkedList();
        int N = 1000000; // 1 million elements

        // Add 1 million elements
        for (int i = 1; i <= N; i++) {
            list.addLast(i);
        }

        assertEquals(N, list.size());

        // Remove all elements
        for (int i = 1; i <= N; i++) {
            list.removeFirst();
        }

        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }
}
