package implementations.linkedList;

public class LinkedList<T> {

    private ListNode<T> initialNode;
    private ListNode<T> currentNode;
    private int size;

    public void add(T data) {
        ListNode<T> listNode = new ListNode<>(data);
        if (initialNode == null) {
            initialNode = listNode;
        } else {
            ListNode<T> temp = currentNode;
            temp.setNext(listNode);
        }
        currentNode = listNode;
        size++;
    }

    public int size() {
        return size;
    }

    public void display() {
        ListNode<T> temp = initialNode;
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getNext();
        }
        System.out.println();
    }

    public void add(int index, T element) {
        ListNode<T> listNode = new ListNode<>(element);
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == 0) {
            addFirst(element);
        } else if (index == size - 1) {
            addLast(element);
        } else {
            ListNode<T> beforeNewNode = initialNode.getNext();
            int pointer = 1;
            while (pointer != (index - 1)) {
                beforeNewNode = beforeNewNode.getNext();
                pointer++;
            }
            listNode.setNext(beforeNewNode.getNext());
            beforeNewNode.setNext(listNode);

        }
        size++;
    }

    public void remove(int index) {
        if (index > size - 1) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        } else if (index == 0) {
            deleteFirst();
        } else if (index == size - 1) {
            deleteLast();
        } else {
            ListNode<T> beforeRemovalNode = initialNode;
            ListNode<T> removalNode = initialNode.getListNode();
            ListNode<T> afterRemovalNode = initialNode.getListNode().getListNode();
            int pointer = 1;
            while (pointer != index) {
                beforeRemovalNode = removalNode;
                removalNode = afterRemovalNode;
                afterRemovalNode = afterRemovalNode.getListNode();
                pointer++;
            }
            beforeRemovalNode.setListNode(afterRemovalNode);
        }
        size--;
    }

    public void addFirst(T data) {
        ListNode<T> listNode = new ListNode<>(data);
        listNode.setNext(initialNode);
        initialNode = listNode;
        size++;
    }


    public void deleteFirst() {
        if (initialNode == null) {
            return;
        } else {
            initialNode = initialNode.getListNode();
            size--;
        }
    }

    public void addLast(T data) {
        ListNode<T> listNode = new ListNode<>(data);
        currentNode.setNext(listNode);
        currentNode = listNode;
        size++;
    }

    public T deleteLast() {
        if (initialNode.hashCode() == currentNode.hashCode()) {
            initialNode = null;
            currentNode = null;
            size--;
            return null;
        }
        ListNode<T> beforeRemovalNode = initialNode;
        ListNode<T> removalNode = initialNode.getListNode();
        while (removalNode.getListNode() != null) {
            beforeRemovalNode = removalNode;
            removalNode = removalNode.getListNode();
        }

        currentNode = beforeRemovalNode;
        currentNode.setListNode(null);
        size--;
        return removalNode.getData();
    }

    public void getInfo() {
        System.out.println("InitialNode = " + initialNode.getData() + ", reference = " + initialNode.getListNode().getData());
        System.out.println("CurrentNode = " + currentNode.getData() + ", reference = " + currentNode.getListNode());
    }

    ///  stack related methods
    public void removeAll() {
        initialNode = null;
        currentNode = null;
        size = 0;
    }

    public T top(){
        return initialNode.getData();
    }

    public T bottom(){
        return currentNode.getData();
    }


}
