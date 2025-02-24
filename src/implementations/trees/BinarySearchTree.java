package implementations.trees;


//
//        1. Insertion Method:
//
//insert(int data): Inserts a new node with the given data into the BST.
//
//        2. Deletion Method:
//
//delete(int data): Deletes the node with the given data from the BST.
//
//        3. Search Method:
//
//search(int data): Searches for the node with the given data in the BST and returns it if found.
//
//4. Traversal Methods:
//
//inorderTraversal(): Performs an inorder traversal of the BST and returns the nodes in ascending order.
//preorderTraversal(): Performs a preorder traversal of the BST and returns the nodes in a specific order.
//postorderTraversal(): Performs a postorder traversal of the BST and returns the nodes in a specific order.
//
//5. Utility Methods:
//
//height(): Returns the height of the BST.
//size(): Returns the number of nodes in the BST.
//isEmpty(): Returns true if the BST is empty, false otherwise.
//minValue(): Returns the minimum value in the BST.
//maxValue(): Returns the maximum value in the BST.
//
//6. Display Method:
//
//display(): Displays the BST in a tree-like structure.
//
//These methods are the most commonly used and are essential for any BST implementation. They allow you to insert, delete, search, traverse, and display the nodes in the BST, as well as retrieve information about the tree's structure and contents.
//
//Here is a summary of the time complexities for these methods:
//
//insert(int data): O(h), where h is the height of the tree
//delete(int data): O(h), where h is the height of the tree
//search(int data): O(h), where h is the height of the tree
//inorderTraversal(): O(n), where n is the number of nodes in the tree
//preorderTraversal(): O(n), where n is the number of nodes in the tree
//postorderTraversal(): O(n), where n is the number of nodes in the tree
//height(): O(h), where h is the height of the tree
//size(): O(n), where n is the number of nodes in the tree
//isEmpty(): O(1)
//minValue(): O(h), where h is the height of the tree
//maxValue(): O(h), where h is the height of the tree
//display(): O(n), where n is the number of nodes in the tree




public class BinarySearchTree {

    private final TreeNode root;
    private int size;




    public BinarySearchTree(int data) {
        root = new TreeNode(data);
        size++;
    }

    public TreeNode getRoot() {
        return root;
    }

    private void addTraversal(TreeNode pointerNode, TreeNode treeNode) {
        if (pointerNode.getData() > treeNode.getData() && pointerNode.getLeftNode() == null) {
            pointerNode.setLeftNode(treeNode);
            treeNode.setParentNode(pointerNode);
        } else if (pointerNode.getData() < treeNode.getData() && pointerNode.getRightNode() == null) {
            pointerNode.setRightNode(treeNode);
            treeNode.setParentNode(pointerNode);
        } else if (pointerNode.getData() > treeNode.getData() && pointerNode.getLeftNode() != null) {
            addTraversal(pointerNode.getLeftNode(), treeNode);
        } else if (pointerNode.getData() < treeNode.getData() && pointerNode.getRightNode() != null) {
            addTraversal(pointerNode.getRightNode(), treeNode);
        }
    }

    private TreeNode searchTraversal(TreeNode pointerNode, int data) {
        if (pointerNode == null || pointerNode.getData() == data) {
            return pointerNode;
        }
        return pointerNode.getData() > data ?
                searchTraversal(pointerNode.getLeftNode(), data)
                :
                searchTraversal(pointerNode.getRightNode(), data);
    }


    public void add(int data) {
        addTraversal(root, new TreeNode(data));
        size++;
    }


    public TreeNode search(int data) {
        return searchTraversal(root, data);
    }


    public int remove(int data) {

        TreeNode pointerNode = searchTraversal(root, data);

        if (pointerNode == null) return -1;

        TreeNode parentNode = pointerNode.equals(root) ? null : pointerNode.getParentNode();


        //if removal node is root
        if (parentNode == null) {
            TreeNode node = pointerNode.getRightNode();

            while (node.getLeftNode() != null) {
                node = node.getLeftNode();
            }
            pointerNode.setData(node.getData());


            return 1;
        }


        // if removal node doesn't have any child in both left and right node
        if (pointerNode.getLeftNode() == null && pointerNode.getRightNode() == null) {

            if (parentNode.getData() > pointerNode.getData()) {
                parentNode.setLeftNode(null);
                pointerNode.setParentNode(null);
            } else {
                parentNode.setRightNode(null);
                pointerNode.setParentNode(null);
            }


            // if removal node only have child in left node
        } else if (pointerNode.getLeftNode() != null && pointerNode.getRightNode() == null) {

            TreeNode treeNode = pointerNode.getLeftNode();

            if (parentNode.getData() > pointerNode.getData()) {
                parentNode.setLeftNode(treeNode);
                treeNode.setParentNode(parentNode);
            } else {
                parentNode.setRightNode(treeNode);
                treeNode.setParentNode(parentNode);
            }

        } else if (pointerNode.getRightNode() != null && pointerNode.getLeftNode() == null) {

            TreeNode treeNode = pointerNode.getRightNode();

            if (parentNode.getData() > pointerNode.getData()) {
                parentNode.setLeftNode(treeNode);
                treeNode.setParentNode(parentNode);
            } else {
                parentNode.setRightNode(treeNode);
                treeNode.setParentNode(parentNode);
            }
        }
        //if removal node have both left and right child nodes
        else {
            TreeNode node = pointerNode.getRightNode();

            while (node.getLeftNode() != null) {
                node = node.getLeftNode();
            }

            pointerNode.setData(node.getData());
            node.getParentNode().setLeftNode(null);

        }
        size--;
        return 1;
    }

    public int minValue() {
        TreeNode node = root;

        while (node.getLeftNode() != null) {
            node = node.getLeftNode();

        }

        return node.getData();
    }

    public int maxValue() {
        TreeNode node = root;

        while (node.getRightNode() != null) {
            node = node.getRightNode();

        }

        return node.getData();
    }

    public int height() {
        int edgeOfMax = 1;
        int edgeOfMin = 1;
        TreeNode node = root;
        while (node.getLeftNode() != null){
            node = node.getLeftNode();
            edgeOfMin++;
        }
        node = root;
        while (node.getRightNode() != null){
            node = node.getRightNode();
            edgeOfMax++;
        }

        return Math.max(edgeOfMax,edgeOfMin);
    }

    public int size(){return size;}

    public boolean isEmpty(){
        return root == null;
    }


}
