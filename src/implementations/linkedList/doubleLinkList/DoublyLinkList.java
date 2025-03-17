package implementations.linkedList.doubleLinkList;


import java.util.ArrayList;
import java.util.List;

class ListNode {
    private ListNode previous;
    private ListNode next;
    private int val;

    public ListNode(ListNode previous, ListNode next, int val) {
        this.previous = previous;
        this.next = next;
        this.val = val;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}


public class DoublyLinkList {

    private ListNode head = null;
    private ListNode tail = null;
    private int index = 0;

    public void insertHead(int val) {
        if (index == 0) {
            head = new ListNode(null, null, val);
            tail = head;
        } else {
            ListNode node = new ListNode(null, head, val);
            head.setPrevious(node);
            head = node;
        }
        index++;
    }

    public void insertTail(int val) {
        if (index == 0) {
            head = new ListNode(null, null, val);
            tail = head;

        } else {
            ListNode node = new ListNode(tail, null, val);
            tail.setNext(node);
            tail = node;
        }
        index++;
    }

    public boolean removeHead() {
        if (index == 0) {
            return false;
        } else if (index == 1) {
            head = null;
            tail = null;
            index--;
            return true;
        } else {
            ListNode node = head.getNext();
            node.setPrevious(null);
            head = node;
            index--;
            return true;
        }
    }

    public boolean removeTail() {
        if (index == 0) {
            return false;
        } else if (index == 1) {
            head = null;
            tail = null;
            index--;
            return true;
        } else {
            ListNode node = tail.getPrevious();
            node.setNext(null);
            tail = node;
            index--;
            return true;
        }
    }

    public void insertAtIndex(int i, int val) {
        if (i == 0) {
            insertHead(val);
        } else if (i == index - 1) {
            insertTail(val);
        } else if (i == index) {
            insertTail(val);

        } else if (index != 0 && index > i) {
            ListNode node = head;
            for (int x = 0; x < i; x++) {
                node = node.getNext();
            }
            ListNode prev = node.getPrevious();
            ListNode newNode = new ListNode(prev, node, val);
            prev.setNext(newNode);
            node.setPrevious(newNode);
            index++;
        }

    }

    public int removeAtIndex(int i) {
        if(i == 0){
            ListNode node = head;
            head = head.getNext();
            index--;
            return node.getVal();
        } else if (i == index-1) {
            ListNode node = tail;
            tail = tail.getPrevious();
            index--;
            return node.getVal();
        }
        if (index == 0 || i == index || i < 0 || i > index) {
            return -1;
        } else  {
            ListNode node = head;
            for (int x = 0; x < i; x++) {
                node = node.getNext();
            }
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            index--;
            return node.getVal();
        }
    }

    public int get(int i) {
        if (i == 0) {
            return head.getVal();
        } else if (i == index - 1) {
            return tail.getVal();
        } else if (i == index) {
            return -1;
        } else {
            ListNode node = head;
            for (int x = 0; x < i; x++) {
                node = node.getNext();
            }
            return node.getVal();
        }

    }

    public void set(int i, int val) {
        if (i == 0) {
            head.setVal(val);
        } else if (i == index - 1) {
            tail.setVal(val);
        } else if (i != index) {
            ListNode node = head;
            for (int x = 0; x < i; x++) {
                node = node.getNext();
            }
            node.setVal(val);
        }
    }

    public boolean isEmpty() {
        return index == 0;
    }

    public int size() {
        return index - 1;
    }

    public ArrayList<Integer> display() {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode node = head;
        for (int i = 0; i < index; i++) {
            list.add(node.getVal());
            node = node.getNext();
        }

        return list;
    }
}
