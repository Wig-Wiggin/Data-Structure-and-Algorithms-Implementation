package implementations.heap;

public class Main {
    public static void main(String[] args) {
        Heap heap = new Heap(13,true);
        heap.insert(3);
        heap.insert(8);
        heap.insert(2);
        heap.insert(9);
        heap.insert(13);
        heap.insert(12);
        heap.insert(1);
        heap.printHeap();
        System.out.println(heap.getPointer());
        heap.remove();
        heap.printHeap();
        System.out.println(heap.getPointer());
    }
}
