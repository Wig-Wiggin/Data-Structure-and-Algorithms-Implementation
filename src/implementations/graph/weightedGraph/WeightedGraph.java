package implementations.graph.weightedGraph;

import java.util.*;

public class WeightedGraph<T> {
    HashMap<T, HashMap<T, Integer>> graph;

    public WeightedGraph() {
        graph = new HashMap<>();
    }

    public int addVertex(T vertex) {
        if (graph.containsKey(vertex)) return 0;

        graph.put(vertex, new HashMap<>());

        return 1;
    }

    public int addEdge(T source, T destination, int weight) {
        if (!graph.containsKey(source) || !graph.containsKey(destination)) return 0;

        graph.get(source).put(destination, weight);
        graph.get(destination).put(source, weight);

        return 1;
    }

    // Remove a vertex from the graph and its associated edges
    public void removeVertex(T vertex) {
        // TODO: Implement
    }

    // Remove an edge between two vertices
    public void removeEdge(T source, T destination) {
        // TODO: Implement
    }

    // Get all neighbors of a vertex and their respective edge weights
    public HashMap<T, Integer> getNeighbors(T vertex) {
        if (graph.containsKey(vertex))
            return graph.get(vertex);

        return null; // Temporary return
    }

    // Get the weight of the edge between two vertices
    public int getEdgeWeight(T source, T destination) {
        if (!graph.containsKey(source) || !graph.containsKey(destination)) return 0;
        if (graph.get(source).containsKey(destination)) {
            return graph.get(source).get(destination);
        }
        return -1; // Temporary return
    }

    // Check if an edge exists between two vertices
    public boolean hasEdge(T source, T destination) {

        return graph.containsKey(source) && graph.containsKey(destination) && graph.get(source).containsKey(destination);
    }

    // Perform a breadth-first search (BFS) starting from the given node
    public void breadthFirstSearch(T startNode) {
        // TODO: Implement
    }

    // Perform a depth-first search (DFS) starting from the given node
    public void depthFirstSearch(T startNode) {
        // TODO: Implement
    }


    // Find the shortest path from the start node using Dijkstra's algorithm
    public int dijkstra(T source, T destination) {
        T node = source;
        HashMap<T, Integer> relations = graph.get(node);
        HashMap<T, Integer> distance = new HashMap<>();
        HashSet<T> visited = new HashSet<>();
        PriorityQueue<Map.Entry<T, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));
        visited.add(source);
        for (T vertex : graph.keySet()) {

            if (vertex.equals(node))
                distance.put(vertex, 0);
            else
                distance.put(vertex, Integer.MAX_VALUE);

        }

        while (!node.equals(destination)) {

            for(T vertex : relations.keySet()){
                if (!visited.contains(vertex)) {

                    int temp = distance.get(node) + relations.get(vertex);

                    if (temp < distance.get(vertex)) {
                        distance.replace(vertex, temp);
                    }
                    queue.add(new AbstractMap.SimpleEntry<>(vertex, temp));
                }
            }

            if(queue.isEmpty())break;
            Map.Entry<T,Integer> map = queue.poll();
            node = map.getKey();
            System.out.println(map);
            visited.add(node);
            relations = graph.get(node);
        }
        System.out.println(distance);
        return distance.get(destination);
    }


    // Check if the graph is connected (i.e., all nodes are reachable from any other node)
    public boolean isConnected() {
        // TODO: Implement
        return false; // Temporary return
    }

    // Display the graph (useful for debugging)
    public void displayGraph() {
        // TODO: Implement
    }
}



