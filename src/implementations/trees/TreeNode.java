package implementations.trees;

//public class TreeNode<T> {
//
//    private TreeNode<T> parentNode;
//    private TreeNode<T> leftNode;
//    private TreeNode<T> rightNode;
//    private T data;
//
//    public TreeNode(T data) {
//        this.data = data;
//    }
//
//    public TreeNode(TreeNode<T> parentNode, T data) {
//        this.parentNode = parentNode;
//        this.data = data;
//    }
//
//    public TreeNode(TreeNode<T> parentNode, TreeNode<T> leftNode, TreeNode<T> rightNode, T data) {
//        this.parentNode = parentNode;
//        this.leftNode = leftNode;
//        this.rightNode = rightNode;
//        this.data = data;
//    }
//
//    public TreeNode<T> getParentNode() {
//        return parentNode;
//    }
//
//    public void setParentNode(TreeNode<T> parentNode) {
//        this.parentNode = parentNode;
//    }
//
//    public TreeNode<T> getLeftNode() {
//        return leftNode;
//    }
//
//    public void setLeftNode(TreeNode<T> leftNode) {
//        this.leftNode = leftNode;
//    }
//
//    public TreeNode<T> getRightNode() {
//        return rightNode;
//    }
//
//    public void setRightNode(TreeNode<T> rightNode) {
//        this.rightNode = rightNode;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public void nodeInfo() {
//        System.out.println("Parent node data = " + parentNode.data + " Left node data = " + leftNode.data + " node data = " + data + " right node data = " + rightNode.data);
//    }
//
//}


import java.util.Objects;

public class TreeNode{

    private TreeNode parentNode;
    private TreeNode leftNode;
    private TreeNode rightNode;
    private int data;

    public TreeNode(int data) {
        this.data = data;
    }

    public TreeNode(TreeNode parentNode, int data) {
        this.parentNode = parentNode;
        this.data = data;
    }

    public TreeNode(TreeNode parentNode, TreeNode leftNode, TreeNode rightNode, int data) {
        this.parentNode = parentNode;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
        this.data = data;
    }

    public TreeNode getParentNode() {
        return parentNode;
    }

    public void setParentNode(TreeNode parentNode) {
        this.parentNode = parentNode;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String nodeInfo() {
        return String.format("Parent node data = %d%nLeft node data = %d%nCurrent node data = %d%nRight node data = %d%n",
                parentNode.getData(), leftNode == null ? null : leftNode.getData(), data, rightNode == null ? null : rightNode.getData());

    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TreeNode treeNode = (TreeNode) o;
        return data == treeNode.data;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(data);
    }
}
