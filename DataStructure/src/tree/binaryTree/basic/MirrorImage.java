package tree.binaryTree.basic;

/**
 * <a href="https://www.geeksforgeeks.org/symmetric-tree-tree-which-is-mirror-image-of-itself/">Mirror Image or Symmetric Tree</a>
 */
public class MirrorImage {

    static class Node{
        Node left;
        Node right;
        int val;
        Node(int val){
            this.val = val;
        }
    }

    public static void main(String[] args){

        /**
         *      1
         *    /   \
         *   2     2
         *  / \   / \
         * 3   4 4   3
         */
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node (2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if(root != null){
            boolean isMirrorImage = isTreeMirrorImage(root.left, root.right);
            System.out.println("Is Given Binary Tree a Mirror Image:" + isMirrorImage);
        } else {
            System.out.println("Tree is Empty");
        }

    }

    private static boolean isTreeMirrorImage(Node leftSubTree, Node rightSubTree) {
        if (leftSubTree == null && rightSubTree == null) return true;

        if (leftSubTree != null && rightSubTree != null) {
            return (leftSubTree.val == rightSubTree.val) &&
                    isTreeMirrorImage(leftSubTree.left, rightSubTree.right) &&
                    isTreeMirrorImage(leftSubTree.right, rightSubTree.left);
        }
        return false;
    }

}
