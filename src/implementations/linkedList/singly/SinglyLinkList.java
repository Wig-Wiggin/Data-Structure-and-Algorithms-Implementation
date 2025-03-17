package implementations.linkedList.singly;

import java.util.ArrayList;


public class SinglyLinkList {

    private static class ListNode {
        int val;
        ListNode next;

        private ListNode(int val) {
            this.val = val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public int getVal() {
            return this.val;
        }

        public ListNode getNext() {
            return next;
        }

        public void setNext(ListNode next) {
            this.next = next;
        }
    }

    private int length = 1;

    private ListNode head;

    private ListNode tail;


    public SinglyLinkList() {

    }

    public int get(int index) {
        if (index > length-1) {
            return -1;
        }
        if(index == length-1){
            if( tail == null){
                return -1;
            }
            return tail.val;
        }
        int result = 0;
        ListNode node = head;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                result = node.getVal();
                break;
            }
            node = node.next;
        }

        return result;
    }

    public void insertHead(int val) {
        if (head == null) {
            head = new ListNode(val);
            tail = head;
            return;
        }
        ListNode temp = head;
        head = new ListNode(val);
        head.setNext(temp);
        length++;
    }

    public void insertTail(int val) {
        if (tail == null) {
            head = new ListNode(val);
            tail = head;
            return;
        }

        ListNode newTail = new ListNode(val);
        tail.setNext(newTail);
        tail = newTail;
        length++;
    }

    public boolean remove(int index) {
        if( index == 0){
            if(head == null ){
                return false;
            }else if (head == tail){
                head = null;
                tail = null;
                length--;
                return true;
            }
            head = head.next;
            length--;
            return true;
        }

        if (index > length-1) {

            return false;

        } else {
            ListNode node = head;
            int count = 0;
            if (index == length-1) {
               while (node.next != tail){
                   node =node.next;
               }
                tail = node;
               length--;
                return true;
            }

            while (count < index-1){
                node = node.next;
                count++;
            }
            node.next = node.next.next;
            length--;
            return true;
        }

    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> list = new ArrayList<>();
        if (head == null) {
            return list;
        }

        ListNode node = head;
        do {
            list.add(node.getVal());
            node = node.next;
        } while (node != null);
        return list;
    }
}
