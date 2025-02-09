import recursive.SelfReferencingException;

public class ListNode {
    private int data;
    private ListNode listNode;

    public ListNode(int data){
        this.data = data;
    }

    public void setListNode(ListNode listNode)  {
        if(this.hashCode() == listNode.hashCode()){
            System.out.println("can't reference itself.");
            return;
        }
        this.listNode = listNode;
    }

    public void setData(int data) {
        this.data = data;
    }

    public ListNode getListNode() {
        return listNode;
    }

    public int getData() {
        return data;
    }

}
