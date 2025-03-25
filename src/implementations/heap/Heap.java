package implementations.heap;

import java.util.Arrays;

public class Heap {
    private final int[] heap;
    private int size;
    private final int capacity;
    private final boolean isMinHeap;
    private int pointer;
    private int index;

    // Constructor
    public Heap(int capacity, boolean isMinHeap) {
        this.capacity = capacity;
        this.size = 0;
        this.isMinHeap = isMinHeap;
        this.heap = new int[capacity];
    }


    // Insert an element into the heap
    public void insert(int value) {
        if (size == capacity) {
            throw new RuntimeException("Heap Overflow");
        }

        for (int i = index; i < capacity; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if (heap[i] == 0) {
                heap[i] = value;
                heapify(i);
                pointer = i;
                size++;
                return;
            } else if (left < capacity && heap[left] == 0) {
                heap[left] = value;
                heapify(left);
                pointer = left;
                size++;
                return;
            } else if (right < capacity && heap[right] == 0) {
                heap[right] = value;
                heapify(right);
                pointer = right;
                index = i + 1;
                size++;
                return;
            }
        }

    }


    // Remove the root element (min or max)
//    public int remove() {
//        if (size == 0) {
//            throw new RuntimeException("Heap Underflow");
//        }
//
//        int result = heap[0];
//        heap[0] = heap[pointer];
//        heap[pointer] = 0;
//        pointer--;
//        size--;
//
//        int index = 0;
//
//        while (heap[index] != 0) {
//
//            int left = 2 * index + 1;
//            int right = 2 * index + 2;
//
//            if (left > size || right > size) {
//                return -1;
//            }
//
//            int compareChildIndex = -1;
//
//            if (heap[left] != 0 && heap[right] != 0) {
//                compareChildIndex = isMinHeap ? (heap[left] <= heap[right] ? left : right) : (heap[left] >= heap[right] ? left : right);
//            } else if (heap[left] != 0) {
//                compareChildIndex = left;
//            } else if (heap[right] != 0) {
//                compareChildIndex = right;
//            }
//
//
//            if ((isMinHeap && heap[index] > heap[compareChildIndex]) || (!isMinHeap && heap[compareChildIndex] > heap[index])) {
//                int temp = heap[index];
//                heap[index] = heap[compareChildIndex];
//                heap[compareChildIndex] = temp;
//            }
//            index = compareChildIndex;
//
//        }
//
//        return result;
//    }



    public int remove() {
        if (size == 0) {
            throw new RuntimeException("Heap Underflow");
        }

        int result = heap[0];  // Store root element to return
        heap[0] = heap[size - 1]; // Move last element to root
        heap[size - 1] = 0;  // Clear last element
        size--;  // Reduce heap size

        int index = 0;

        while (true) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int smallestOrLargest = index;

            boolean hasLeft = left < size;
            boolean hasRight = right < size;

            if (hasLeft && ((isMinHeap && heap[left] < heap[smallestOrLargest]) || (!isMinHeap && heap[left] > heap[smallestOrLargest]))) {
                smallestOrLargest = left;
            }

            if (hasRight && ((isMinHeap && heap[right] < heap[smallestOrLargest]) || (!isMinHeap && heap[right] > heap[smallestOrLargest]))) {
                smallestOrLargest = right;
            }

            if (smallestOrLargest == index) break;  // If no swaps needed, heap is valid

            // Swap and continue heapifying
            int temp = heap[index];
            heap[index] = heap[smallestOrLargest];
            heap[smallestOrLargest] = temp;

            index = smallestOrLargest;  // Move down
        }

        return result;
    }




    public int getPointer() {
        return pointer;
    }


    // Get the root element (min or max)
    public int getRoot() {
        return heap[0];
    }

    // Heapify the heap
    public void heapify(int index) {
        if (index != 0) {
            int parentIndex = (index - 1) / 2;
            if ((isMinHeap && heap[parentIndex] > heap[index]) || (!isMinHeap && heap[index] > heap[parentIndex])) {
                int temp = heap[parentIndex];
                heap[parentIndex] = heap[index];
                heap[index] = temp;
                heapify(parentIndex);
            }


        }
    }

    // Get the parent of a node
    public int parent(int index) {
        if (index > size) {
            throw new RuntimeException("Invalid Index");
        }
        return (index - 1) / 2;
    }

    // Get the left child of a node
    public int leftChild(int index) {
        if (index > size) {
            throw new RuntimeException("Invalid Index");
        }
        return 2 * index + 2;
    }

    // Get the right child of a node
    public int rightChild(int index) {
        if (index > size) {
            throw new RuntimeException("Invalid Index");
        }
        return 2 * index + 1;
    }

    // Swap two elements in the heap
    public void swap(int index1, int index2) {
        // Implementation here
    }

    // Check if the heap is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the heap
    public int size() {
        return size;
    }

    // Print the heap (optional)
    public void printHeap() {
        System.out.println(Arrays.toString(heap));
    }

    // Check if the heap is a min-heap or max-heap
    public boolean isMinHeap() {

        return isMinHeap;
    }

    public int peek() {
        return heap[0];
    }
}
