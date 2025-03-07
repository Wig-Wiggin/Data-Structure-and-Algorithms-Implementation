import java.util.*;

public class Test {
    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        queue.add(200);
//        queue.add(4);
//        queue.add(1);
//        queue.add(3);
//        System.out.println(queue);
//        System.out.println(queue.poll());

        PriorityQueue<Map.Entry<Integer, String>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getKey));
        queue.add(new AbstractMap.SimpleEntry<>(0, "A"));
        queue.add(new AbstractMap.SimpleEntry<>(3, "B"));
        queue.add(new AbstractMap.SimpleEntry<>(7, "C"));
        queue.add(new AbstractMap.SimpleEntry<>(4, "D"));
        queue.add(new AbstractMap.SimpleEntry<>(10, "E"));
        queue.add(new AbstractMap.SimpleEntry<>(6, "F"));
        queue.add(new AbstractMap.SimpleEntry<>(2, "G"));
        queue.add(new AbstractMap.SimpleEntry<>(12, "H"));
       while (!queue.isEmpty()){
           System.out.println(queue.poll());
       }

    }
}
