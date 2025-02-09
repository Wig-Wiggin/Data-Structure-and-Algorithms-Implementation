public class LinkedList<T extends ListNode> {

    private ListNode initialNode;
    private ListNode currentNode;


    public void getInfo(){
        System.out.println("InitialNode = "+ initialNode.getData()+", reference = "+initialNode.getListNode().getData());
        System.out.println("CurrentNode = "+ currentNode.getData()+", reference = "+currentNode.getListNode());
    }

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
        while (temp != null) {
            System.out.print(temp.getData() + " ");
            temp = temp.getListNode();
        }
        System.out.println();
    }

    public void addFirst(ListNode listNode){
        listNode.setListNode(initialNode);
        initialNode = listNode;
    }

    public void deleteFirst(){
        if(initialNode == null){
            return;
        }else {
            initialNode = initialNode.getListNode();
        }
    }

    public void addLast(ListNode listNode){
        currentNode.setListNode(listNode);
        currentNode = listNode;
    }

    public void deleteLast(){
        if(initialNode.hashCode() == currentNode.hashCode()){
            initialNode =null;
            currentNode = null;
            return;
        }
        ListNode tempNode1 = initialNode;
        ListNode tempNode2 = initialNode.getListNode();
        while (tempNode2.getListNode() != null) {
            tempNode1 = tempNode2;
            tempNode2 = tempNode2.getListNode();
        }

        currentNode = tempNode1;
        currentNode.setListNode(null);

    }
}
