package implementations.trees;

public class BinarySearchTree {

    private final TreeNode root;

    public BinarySearchTree(int data) {
        root = new TreeNode(data);
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

    public void add(int data) {
        addTraversal(root, new TreeNode(data));
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



public TreeNode search(int data) {

    return searchTraversal(root,data);
}
}
