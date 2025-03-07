package implementations.graph.simpleGraph;


import java.util.*;


public class SimpleGraph<T> {

    private HashMap<T, HashSet<T>> graph;

    public SimpleGraph() {
        graph = new HashMap<>();
    }

    public void addVertex(T vertex) {
        if (graph.containsKey(vertex)) return;
        graph.put(vertex, new HashSet<>());

    }

    public int addEdge(T source, T destination) {
        if (!graph.containsKey(source) || !graph.containsKey(destination)) return 0;
        if (graph.get(source).stream().anyMatch(destination::equals) || graph.get(destination).stream().anyMatch(source::equals))
            return 0;

        graph.get(source).add(destination);
        graph.get(destination).add(source);


        return 1;
    }

    public int deleteEdge(T host, T connector) {
        if (!graph.containsKey(host) || !graph.containsKey(connector)) return 0;
        if (graph.get(host).stream().anyMatch(connector::equals)) return 0;

        HashSet<T> relations = graph.get(host);

        relations.remove(connector);


        return 1;
    }

    public int deleteVertex(T vertex) {

        if (!graph.containsKey(vertex)) return 0;

        graph.remove(vertex);

        return 1;
    }

//      A
//     / \
//    B   C
//   /     \
//  D       E


    public void breadthFirstSearch(T startNode) {
        ArrayDeque<T> deque = new ArrayDeque<>();
        HashSet<T> visited = new HashSet<>();
        visited.add(startNode);
        deque.add(startNode);

        while (!deque.isEmpty()) {
            T vertex = deque.poll();
            System.out.print(vertex + " ");

            HashSet<T> neighbours = graph.getOrDefault(vertex, HashSet.newHashSet(0));

            for (T neighbour : neighbours) {
                if (visited.stream().noneMatch(neighbour::equals)) {
                    deque.add(neighbour);
                    visited.add(neighbour);
                }

            }
        }
    }


//        A
//       / \
//      B   C
//     / \   \
//    D   E   F


    public void depthFirstSearch(T startNode,Stack<T> stack,HashSet<T> visited){
        if(visited.stream().noneMatch(startNode::equals)){
            return;
        }
        graph.get(startNode).forEach(vertex->{
            if(visited.contains(vertex)){
                stack.add(vertex);
                visited.add(vertex);
                depthFirstSearch(vertex,stack,visited);
            }
        });
    }


    public Stack<T>  depthFirstSearch(T startNode){
        HashSet<T> visited = new HashSet<>();
        Stack<T> stack = new Stack<>();
        visited.add(startNode);
        stack.add(startNode);
        depthFirstSearch(startNode,stack,visited);
        return stack;
    }




    public HashSet<T> getConnections(T host) {
        return graph.get(host);
    }

    public void deleteGraph() {
        graph = null;
    }

}
