package test.dataStructures;

import static org.junit.jupiter.api.Assertions.*;

import implementations.heap.Heap;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class HeapTest {
    private Heap minHeap;
    private Heap maxHeap;

    @BeforeEach
    void setUp() {
        minHeap = new Heap(5, true); // Min-Heap with capacity 5
        maxHeap = new Heap(5, false); // Max-Heap with capacity 5
    }

    @Test
    void testInsertAndHeapPropertyMinHeap() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        minHeap.insert(3);
        minHeap.insert(7);

        assertEquals(3, minHeap.peek()); // Smallest value should be at the root
    }

    @Test
    void testInsertAndHeapPropertyMaxHeap() {
        maxHeap.insert(10);
        maxHeap.insert(5);
        maxHeap.insert(20);
        maxHeap.insert(30);
        maxHeap.insert(7);

        assertEquals(30, maxHeap.peek()); // Largest value should be at the root
    }

    @Test
    void testGetRoot() {
        minHeap.insert(15);
        minHeap.insert(5);
        assertEquals(5, minHeap.getRoot()); // Min-Heap should return smallest element
    }

    @Test
    void testHeapify() {
        minHeap.insert(50);
        minHeap.insert(30);
        minHeap.insert(40);
        minHeap.insert(10);
        minHeap.insert(20);

        assertEquals(10, minHeap.peek()); // Min-Heap should still have smallest value at root
    }

    @Test
    void testParentChildMethods() {
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(30);

        assertEquals(0, minHeap.parent(1)); // Parent of index 1 should be index 0
        assertEquals(2, minHeap.leftChild(0)); // Left child of index 0 should be index 2
        assertEquals(1, minHeap.rightChild(0)); // Right child of index 0 should be index 1
    }

    @Test
    void testHeapOverflow() {
        for (int i = 0; i < 5; i++) {
            minHeap.insert(i);
        }
        assertThrows(RuntimeException.class, () -> minHeap.insert(100)); // Heap full
    }

    @Test
    void testHeapUnderflow() {
        assertThrows(RuntimeException.class, minHeap::remove); // Heap is empty
    }

    @Test
    void testRemove() {
        minHeap.insert(10);
        minHeap.insert(5);
        minHeap.insert(20);
        assertEquals(5, minHeap.remove()); // Removing root (min element)
        assertEquals(10, minHeap.peek()); // Next smallest should be at root
    }

    @Test
    void testIsEmpty() {
        assertTrue(minHeap.isEmpty()); // Heap should be empty initially
        minHeap.insert(10);
        assertFalse(minHeap.isEmpty()); // Heap is no longer empty
    }

    @Test
    void testSize() {
        assertEquals(0, minHeap.size()); // Initially empty
        minHeap.insert(10);
        minHeap.insert(20);
        assertEquals(2, minHeap.size()); // Size should update correctly
    }

//    @Test
//    void testSwap() {
//        minHeap.insert(10);
//        minHeap.insert(20);
//        minHeap.swap(0, 1); // Swap root with second element
//        assertEquals(20, minHeap.peek()); // Swapped, so root should now be 20
//    }

    @Test
    void testPrintHeap() {
        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(5);
        minHeap.printHeap(); // Should print heap structure
    }

    @Test
    void testIsMinHeap() {
        assertTrue(minHeap.isMinHeap()); // Should return true for min-heap
        assertFalse(maxHeap.isMinHeap()); // Should return false for max-heap
    }

    @Test
    void testGetPointer() {
        minHeap.insert(10);
        int pointer = minHeap.getPointer();
        assertTrue(pointer >= 0 && pointer < 5); // Pointer should be within heap size
    }
}
