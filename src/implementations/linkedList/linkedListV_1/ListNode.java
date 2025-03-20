package implementations.linkedList.linkedListV_1;

public class ListNode<T>{
    private T data;
    private ListNode<T> next;

    public ListNode(T data){
        this.data = data;
    }

    public void setNext(ListNode<T> next)  {
        if (next == null){  //** making last node
            this.next =null;
            return;
        }
        if(this.hashCode() == next.hashCode()){
            System.out.println("can't reference itself.");
            return;
        }
        this.next = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public T getData() {
        return data;
    }

    public ListNode<T> getListNode() {
        return next;
    }

    public void setListNode(ListNode<T> listNode) {
        next = listNode;
    }
}
