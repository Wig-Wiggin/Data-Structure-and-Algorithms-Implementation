public class LinkedList<T extends ListNode> {

    private ListNode initialNode;
    private ListNode currentNode;

    public void add(T data) {
        if (initialNode == null) {
            initialNode = data;
        } else {
            ListNode temp = currentNode;
            temp.setListNode(data);
        }
        currentNode = data;

    }

    public void display() {
        ListNode temp = initialNode;
        while (true) {
            if (temp == null) {
                return;
            }
            System.out.print(temp.getData() + " ");
            temp = temp.getListNode();
        }
    }

    public void addFirst(ListNode listNode){
        listNode.setListNode(initialNode);
        initialNode = listNode;
    }
}
