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


    public TreeNode search(int data) {return searchTraversal(root,data);}

    ///  NOT FINISH YET
    private void removeTraversal(TreeNode pointerNode,int data){
        if(pointerNode == null)return ;

        if(pointerNode.getData() == data){

            TreeNode parentNode = pointerNode.getParentNode();

            // if removalNode doesn't have both left and right child
            if(pointerNode.getLeftNode() == null && pointerNode.getRightNode() == null){

                if(parentNode.getLeftNode() != null && parentNode.getLeftNode().equals(pointerNode)){
                    parentNode.setLeftNode(null);
                    pointerNode.setParentNode(null);
                } else if (parentNode.getRightNode() != null && parentNode.getRightNode().equals(pointerNode)) {
                    parentNode.setRightNode(null);
                    pointerNode.setParentNode(null);
                }

            }else if (pointerNode.getRightNode() != null){
                if(parentNode.getRightNode() != null && parentNode.getRightNode().equals(pointerNode)){
                    if(pointerNode.getRightNode() != null){
                        TreeNode node = pointerNode.getRightNode();
                        while (true){
                            if(node.getLeftNode() == null)break;
                            node = node.getLeftNode();
                        }
                        System.out.println(node.nodeInfo());
                    }
                } else if (parentNode.getLeftNode() != null && parentNode.getLeftNode().equals(pointerNode)) {

                }
            }

        }



    }

    public void remove(int data){

         removeTraversal(root,data);
    }

}
