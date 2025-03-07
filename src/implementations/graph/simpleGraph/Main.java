package implementations.graph.simpleGraph;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        SimpleGraph<String> graph = new SimpleGraph<>();


//        A
//       / \
//      B   C
//     /     \
//    D       E

//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addEdge("A","B");
//        graph.addEdge("A","C");
//        graph.addEdge("B","D");
//        graph.addEdge("C","E");
//
//        String[] result = graph.getConnections("A");
//        System.out.println("Relation of A = " + Arrays.toString(result));
//
//        result = graph.getConnections("B");
//        System.out.println("Relation of B = " + Arrays.toString(result));
//
//        result = graph.getConnections("C");
//        System.out.println("Relation of C = " + Arrays.toString(result));
//
//        result = graph.getConnections("D");
//        System.out.println("Relation of D = " + Arrays.toString(result));
//
//        result = graph.getConnections("E");
//        System.out.println("Relation of E = " + Arrays.toString(result));
//
//        graph.breadthFirstSearch("A");

//--------------------------------------------------------------------------------------------------------


//        A
//       / \
//      B   C
//     / \   \
//    D   E   F

//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//        graph.addVertex("F");
//
//        graph.addEdge("A","B");
//        graph.addEdge("A","C");
//        graph.addEdge("B","D");
//        graph.addEdge("B","E");
//        graph.addEdge("C","F");
//
//
//        Object[] result = graph.getConnections("A");
//        System.out.println("Relation of A = " + Arrays.toString(result));
//
//        result = graph.getConnections("B");
//        System.out.println("Relation of B = " + Arrays.toString(result));
//
//        result = graph.getConnections("C");
//        System.out.println("Relation of C = " + Arrays.toString(result));
//
//        result = graph.getConnections("D");
//        System.out.println("Relation of D = " + Arrays.toString(result));
//
//        result = graph.getConnections("E");
//        System.out.println("Relation of E = " + Arrays.toString(result));
//
//        result = graph.getConnections("F");
//        System.out.println("Relation of F = " + Arrays.toString(result));
//--------------------------------------------------------------------------------------------------------

//                     A
//                   / | \
//                  B  C  D
//                 /|  |  |\
//                E F  G  H I
//               /  |  |  |  \
//              J   K  L  M  N
//               \ /     \| /
//                O       P
//                 \     /
//                  Q - R

        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addVertex("E");
        graph.addVertex("F");
        graph.addVertex("G");
        graph.addVertex("H");
        graph.addVertex("I");
        graph.addVertex("J");
        graph.addVertex("K");
        graph.addVertex("L");
        graph.addVertex("M");
        graph.addVertex("N");
        graph.addVertex("O");
        graph.addVertex("P");
        graph.addVertex("Q");
        graph.addVertex("R");

        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");

        graph.addEdge("B", "E");
        graph.addEdge("B", "F");

        graph.addEdge("C", "G");

        graph.addEdge("D", "H");
        graph.addEdge("D", "I");

        graph.addEdge("E", "J");

        graph.addEdge("F", "K");

        graph.addEdge("G", "L");

        graph.addEdge("H", "M");

        graph.addEdge("I", "N");

        graph.addEdge("J", "O");

        graph.addEdge("K", "O");

        graph.addEdge("L", "P");

        graph.addEdge("M", "P");
        graph.addEdge("N", "P");
        graph.addEdge("O", "Q");

        graph.addEdge("R", "P");

        graph.addEdge("Q", "R");


        HashSet<String> result = graph.getConnections("A");
        System.out.println("Relation of A = " + result.toString());

        result = graph.getConnections("B");
        System.out.println("Relation of B = " + result.toString());

        result = graph.getConnections("C");
        System.out.println("Relation of C = " + result.toString());

        result = graph.getConnections("D");
        System.out.println("Relation of D = " + result.toString());

        result = graph.getConnections("E");
        System.out.println("Relation of E = " + result.toString());

        result = graph.getConnections("F");
        System.out.println("Relation of F = " + result.toString());

        result = graph.getConnections("G");
        System.out.println("Relation of G = " + result.toString());

        result = graph.getConnections("H");
        System.out.println("Relation of H = " + result.toString());

        result = graph.getConnections("I");
        System.out.println("Relation of I = " + result.toString());

        result = graph.getConnections("J");
        System.out.println("Relation of J = " + result.toString());

        result = graph.getConnections("K");
        System.out.println("Relation of K = " + result.toString());

        result = graph.getConnections("L");
        System.out.println("Relation of L = " + result.toString());

        result = graph.getConnections("M");
        System.out.println("Relation of M = " + result.toString());

        result = graph.getConnections("N");
        System.out.println("Relation of N = " + result.toString());

        result = graph.getConnections("O");
        System.out.println("Relation of O = " + result.toString());

        result = graph.getConnections("P");
        System.out.println("Relation of P = " + result.toString());

        result = graph.getConnections("Q");
        System.out.println("Relation of Q = " + result.toString());

        result = graph.getConnections("R");
        System.out.println("Relation of R = " + result.toString());


//
//
//        System.out.println("Expected: A, B, C, D, E, F, G, H, I, J, K, L, M, N, O, P, Q, R");
//        System.out.print("Breath First Search from A = ");
//        graph.breadthFirstSearch("A");
//        System.out.println();
////
//        System.out.println("Expected: P, L, M, N, R, G, H, I, Q, C, D, O, A, J, K, B, E, F");
//        System.out.print("Breath First Search from p = ");
//        graph.breadthFirstSearch("P");
//        System.out.println();
//
//        System.out.println("Expected: Q, O, R, J, K, P, E, F, L, M, N, B, G, H, I, A, C, D");
//        System.out.print("Breath First Search from Q = ");
//        graph.breadthFirstSearch("Q");
//        System.out.println();

        System.out.println("Expected: ");


//--------------------------------------------------------------------------------------------------------
//        A-B-C
//        |  /\
//         D   E
//        graph.addVertex("A");
//        graph.addVertex("B");
//        graph.addVertex("C");
//        graph.addVertex("D");
//        graph.addVertex("E");
//
//        graph.addEdge("A", "B");
//        graph.addEdge("A", "D");
//        graph.addEdge("A", "C");
//        graph.addEdge("C","D");
//        graph.addEdge("C", "E");
//
//        HashSet<String> result = graph.getConnections("A");
//        System.out.println("Relation of A = " + result.toString());
//
//        result = graph.getConnections("B");
//        System.out.println("Relation of B = " + result.toString());
//
//        result = graph.getConnections("C");
//        System.out.println("Relation of C = " + result.toString());
//
//        result = graph.getConnections("D");
//        System.out.println("Relation of D = " + result.toString());
//
//        result = graph.getConnections("E");
//        System.out.println("Relation of E = " + result.toString());
//
//        graph.depthFirstSearch("A");



    }
}
