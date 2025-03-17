package implementations.linkedList.singly;

public class Main {
    public static void main(String[] args) {


        // ["insertTail", 1, "insertTail", 2, "get", 1, "remove", 1, "insertTail", 2, "get", 1, "get", 0]

        SinglyLinkList list = new SinglyLinkList();
     //["insertHead", 1, "remove", 2, "remove", 1]
        list.insertHead(1);
        list.remove(2);
        list.remove(1);
    }
}
