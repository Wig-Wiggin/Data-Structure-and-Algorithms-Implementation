package implementations.trees;

public class BinarySearchTree {

    private final TreeNode root;


    public BinarySearchTree(int data) {
        root = new TreeNode(data);
    }

    public TreeNode getRoot(){return  root;}

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
        return searchTraversal(root, data);
    }


    public void remove(int data) {

        TreeNode pointerNode = searchTraversal(root, data);

        if (pointerNode == null) return;

        TreeNode parentNode = pointerNode.equals(root) ? null :  pointerNode.getParentNode();


        //if removal node is root
        if(parentNode == null){
            TreeNode node = pointerNode.getRightNode();

            while (node.getLeftNode() != null) {
                node = node.getLeftNode();
            }
            pointerNode.setData(node.getData());
            return;
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
        }


}
