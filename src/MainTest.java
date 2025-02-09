import recursive.SelfReferencingException;

public class MainTest {
    public static void main(String[] args) throws SelfReferencingException {
        LinkedList<ListNode> list = new LinkedList<>();
        ListNode node = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode firstAdd = new ListNode(100);

        list.add(node);
        list.add(node1);
        list.add(node2);
        list.add(node3);
        list.add(node4);
        list.addFirst(firstAdd);
        list.display();
        list.deleteFirst();
        list.display();
        list.addLast(new ListNode(12));
        list.display();
        list.deleteLast();
        list.display();


    }
}
