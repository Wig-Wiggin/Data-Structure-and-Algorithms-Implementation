package implementations.trees;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree(10);
        tree.add(8);
        tree.add(15);
        tree.add(5);
        tree.add(4);
        tree.add(18);
        tree.add(13);
        tree.add(12);
        tree.add(11);
        tree.add(17);
        tree.add(16);
        tree.add(24);
        tree.add(1);
        tree.add(99);
        tree.remove(1);
        System.out.println(tree.size());
        System.out.println(tree.height());



//        tree.remove(15);
//

//        System.out.println(tree.search(16).nodeInfo());
//        System.out.println(tree.search(18).nodeInfo());

//        tree.remove(10);
//        TreeNode result = tree.search(10);
//        System.out.println(result != null ? result : "not found (removed successfully)");
//
//        System.out.println(tree.getRoot().nodeInfo());

//        System.out.println(tree.search(12).nodeInfo());
//        System.out.println("--------------");
//        TreeNode treeNode = tree.search(15);
//        System.out.println("before");
//        System.out.println(treeNode.nodeInfo());
//        tree.remove(15);
//        System.out.println("after");
//        System.out.println(treeNode.nodeInfo());
//        System.out.println("----");


//        System.out.println(tree.search(11).nodeInfo());
//        System.out.println(tree.search(18).nodeInfo());
//        TreeNode treeNode = tree.search(13);
//        System.out.println(treeNode);
//        System.out.println(tree.search(12).nodeInfo());
//        System.out.println(tree.search(11).nodeInfo());

//        System.out.println("-------removal section---------");
//        tree.remove(4);
//        TreeNode result = tree.search(4);
//        System.out.println(result != null ? result : "not found (removed successfully)");
//        tree.remove(14);
//        result = tree.search(14);
//        System.out.println(result != null ? result : "not found (removed successfully)");
//        System.out.println("-------------");
//        System.out.println("before removal");
//        System.out.println(tree.search(10).nodeInfo());
//        tree.remove(8);
//        result = tree.search(8);
//        System.out.println(result != null ? result : "not found (removed successfully)");
//        System.out.println(tree.search(10).nodeInfo());


//        System.out.println("-------------------");
//        System.out.println(tree.getRoot().nodeInfo());
//        tree.remove(15);
//        TreeNode result = tree.search(15);
//        System.out.println(result != null ? result : "not found (removed successfully)");
//        System.out.println("-----");
     //   System.out.println(tree.getRoot().nodeInfo());
//        System.out.println(tree.search(11).nodeInfo());
//        System.out.println(tree.search(13));

    }
}
