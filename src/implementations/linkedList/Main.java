package implementations.linkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 1; i<=5 ;i++){
            list.add(i);
        }

        list.display();

        list.addFirst(10);
        list.display();
        list.deleteFirst();
        list.display();
        list.addLast(12);
        list.display();
        list.deleteLast();
        list.display();
        //  list.add(100,new implementations.linkedList.ListNode(12)); index out of bound error check

        list.add(2, 10);
        list.display();
//        list.remove(0);

       list.add(4,10);
        list.display();
        System.out.println(list.size());



    }
}




















