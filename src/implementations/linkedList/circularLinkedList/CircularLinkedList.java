package implementations.linkedList.circularLinkedList;

public class CircularLinkedList {


    // Node class for the linked list
    public static class Node {
        int data;
        public Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private Node tail;
    private int size;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node getTail() {
        return tail;
    }

    public void setTail(Node tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    // Constructor
    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // Add node at the beginning
    public void addFirst(int value) {
        if (size == 0) {
            head = new Node(value);
            tail = head;
            tail.next = head;

        } else {
            Node node = new Node(value);
            node.next = head;
            head = node;

        }
        size++;
    }

    // Add node at the end
    public void addLast(int value) {
        if (size == 0) {
            head = new Node(value);
            tail = head;
            tail.next = head;
        } else {
            Node node = new Node(value);
            tail.next = node;
            tail = node;
            node.next = head;
        }
        size++;
    }

    // Insert node at a specific position
    public void insertAt(int index, int value) {
        if (index == 0) {
            addFirst(value);
        } else if (( index-1) == size) {
            addLast(value);
        } else if (index > 0 && index < size) {
            Node node = head;
            for (int i = 0; i != index; i++) {
                node = node.next;
            }
            Node temp = node.next;
            Node newNode = new Node(value);
            node.next = newNode;
            newNode.next = temp;
            size++;
        }
    }

    // Remove the first node
    public void removeFirst() {
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else if (size > 1) {

            head = head.next;
            tail.next = head;
            size--;
        }
    }

    // Remove the last node
    public void removeLast() {
        if (size == 1) {
            head = null;
            tail = null;
            size--;
        } else if (size > 1) {
            Node node = head;
            while (node.next != tail) {
                node = node.next;
            }
            tail = node;
            node.next = head;
            size--;
        }
    }

    // Remove a node at a specific position
    public void removeAt(int index) {
        if (index == 0) {
            removeFirst();
        } else if (index == size - 1) {
            removeLast();
        } else if (index < size) {
            Node node = head;
            for (int i = 1; i < index; i++) {
                node = node.next;
            }
            node.next = node.next.next;
            size--;

        }
    }

    // Search for a value in the list
    public boolean search(int value) {
        Node node = head;
        do {
            if (node.data == value) {
                return true;
            }
            node = node.next;
        } while (node != head);

        return false;
    }

    // Get the size of the list
    public int size() {
        return size;
    }

    // Check if the list is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Print the linked list elements
    public void printList() {
        Node node = head;
        do{
            System.out.print(node.data);
            node = node.next;
        }while (node.next != head);
    }
}
