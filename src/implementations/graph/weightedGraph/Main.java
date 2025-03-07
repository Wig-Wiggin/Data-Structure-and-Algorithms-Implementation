package implementations.graph.weightedGraph;

public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();







        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");

        graph.addEdge("A", "C", 3);
        graph.addEdge("A", "F", 2);
        graph.addEdge("C", "F", 2);
        graph.addEdge("C", "E", 1);
        graph.addEdge("C", "D", 4);
        graph.addEdge("F", "E", 3);
        graph.addEdge("B", "F", 6);
        graph.addEdge("B", "D", 1);
        graph.addEdge("B", "G", 2);
        graph.addEdge("E", "B", 2);
        graph.addEdge("G", "F", 5);
        System.out.println( "Shortest path for B = "+  graph.dijkstra("A","B"));
//        System.out.println( "Shortest path for D = "+  graph.dijkstra("A","D"));
//        System.out.println( "Shortest path for E = "+  graph.dijkstra("A","E"));
//        System.out.println( "Shortest path for G = "+  graph.dijkstra("A","G"));


//        graph.addEdge("A","B",3);
//        graph.addEdge("A","G",2);
//
//        graph.addEdge("B","E",7);
//        graph.addEdge("B","D",1);
//
//        graph.addEdge("C","D",3);
//        graph.addEdge("C","E",5);
//
//        graph.addEdge("D","F",6);
//        graph.addEdge("D","H",8);
//
//        graph.addEdge("E","H",2);
//
//        graph.addEdge("F","G",4);
//
//        graph.dijkstra("A","H");





    }
}
