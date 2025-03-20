package implementations.stack;

import implementations.linkedList.linkedListV_1.LinkedList;

public class DynamicsStack<T> {

    private final LinkedList<T> list;

    private int size;

    public DynamicsStack(int size) {
        list = new LinkedList<>();
        this.size = size;
    }

    public void push(T data) {
        if (list.size() == size) {
            size += size;
        }
        list.add(data);
    }

    public T pop() {
        return list.deleteLast();
    }

    public void delete() {
        list.removeAll();
    }

    public int size() {
        return size;
    }

    public T top() {
        return list.top();
    }

    public T bottom() {
        return list.bottom();
    }

    public void display() {
        list.display();
    }


    public int isEmpty() {
        return list.size() == 0 ? 1 : 0;
    }

    public int isFull() {
        return list.size() == size ? 1 : 0;
    }

}
