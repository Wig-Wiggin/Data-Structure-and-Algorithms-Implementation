package implementations.trees;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree(10);
        tree.add(8);
        tree.add(15);
        tree.add(14);
        tree.add(4);
        tree.add(3);
        tree.add(5);
        TreeNode node = tree.search(4);
        System.out.println(node == null ? "not found" : node.nodeInfo());
    }
}
