package implementations.linkedList.doubleLinkList;

public class Main {
    public static void main(String[] args) {
        DoublyLinkList dll = new DoublyLinkList();

        System.out.println("==== TEST 1: Insert Head ====");
        dll.insertHead(10); // [10]
        dll.insertHead(20); // [20, 10]
        dll.insertHead(30); // [30, 20, 10]
        System.out.println(dll.display()); // Expected: [30, 20, 10]

        System.out.println("==== TEST 2: Insert Tail ====");
        dll.insertTail(40); // [30, 20, 10, 40]
        dll.insertTail(50); // [30, 20, 10, 40, 50]
        System.out.println(dll.display()); // Expected: [30, 20, 10, 40, 50]

        System.out.println("==== TEST 3: Remove Head ====");
        dll.removeHead(); // [20, 10, 40, 50]
        dll.removeHead(); // [10, 40, 50]
        System.out.println(dll.display()); // Expected: [10, 40, 50]

        System.out.println("==== TEST 4: Remove Tail ====");
        dll.removeTail(); // [10, 40]
        dll.removeTail(); // [10]
        System.out.println(dll.display()); // Expected: [10]

        System.out.println("==== TEST 5: Insert At Index ====");
        dll.insertAtIndex(0, 5);   // [5, 10]
        dll.insertAtIndex(2, 15);  // [5, 10, 15]
        dll.insertAtIndex(1, 7);   // [5, 7, 10, 15]
        System.out.println(dll.display()); // Expected: [5, 7, 10, 15]

        System.out.println("==== TEST 6: Remove At Index ====");
        dll.removeAtIndex(1); // [5, 10, 15]
        dll.removeAtIndex(0); // [10, 15]
        System.out.println(dll.display()); // Expected: [10, 15]

        System.out.println("==== TEST 7: Get Values ====");
        System.out.println(dll.get(0)); // Expected: 10
        System.out.println(dll.get(1)); // Expected: 15
        System.out.println(dll.get(2)); // Expected: -1 (out of bounds)

        System.out.println("==== TEST 8: Set Values ====");
        dll.set(1, 25); // [10, 25]
        System.out.println(dll.display()); // Expected: [10, 25]
        dll.set(2, 99); // Invalid, out of bounds (should be ignored)

        System.out.println("==== TEST 9: Edge Cases - Empty List Operations ====");
        dll.removeHead(); // [25]
        dll.removeHead(); // []
        System.out.println(dll.display()); // Expected: []
        dll.removeHead(); // Should handle gracefully (no crash)
        dll.removeTail(); // Should handle gracefully

        System.out.println("==== TEST 10: Single Element List Operations ====");
        dll.insertHead(99); // [99]
        dll.removeTail();  // []
        System.out.println(dll.display()); // Expected: []

        System.out.println("==== TEST 11: Insert At Invalid Indices ====");
        dll.insertAtIndex(-1, 5); // Invalid (should be ignored)
        dll.insertAtIndex(100, 5); // Invalid (should be ignored)
        System.out.println(dll.display()); // Expected: []

        System.out.println("==== TEST 12: Remove At Invalid Indices ====");
        dll.removeAtIndex(-1); // Invalid (should be ignored)
        dll.removeAtIndex(10); // Invalid (should be ignored)

        System.out.println("==== TEST 13: Check Empty List ====");
        System.out.println(dll.isEmpty()); // Expected: true

        System.out.println("==== TEST 14: Check Size ====");
        dll.insertHead(5);
        dll.insertHead(10);
        System.out.println(dll.size()); // Expected: 2

        System.out.println("==== TEST 15: Stress Test - Large Insertions ====");
        for (int i = 1; i <= 1000; i++) {
            dll.insertTail(i);
        }
        System.out.println(dll.size()); // Expected: 1002 (2 from before + 1000 new elements)

        System.out.println("==== TEST 16: Stress Test - Large Deletions ====");
        for (int i = 1; i <= 500; i++) {
            dll.removeHead();
        }
        System.out.println(dll.size()); // Expected: 502
    }
}
