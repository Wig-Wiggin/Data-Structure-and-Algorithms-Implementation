package implementations.trees;

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
                parentNode == null ? null : parentNode.getData(), leftNode == null ? null : leftNode.getData(), data, rightNode == null ? null : rightNode.getData());

    }

}
