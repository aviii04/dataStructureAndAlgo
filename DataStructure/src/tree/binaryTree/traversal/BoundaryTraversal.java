package tree.binaryTree.traversal;

public class BoundaryTraversal {
    
    static class Node {
        int val;
        Node left;
        Node right;
        Node(int val) {
            this.val = val;
        }
    }
    
    public static void main(String[] args){

        /** Tree structure
         *             1
         *           /   \
         *         2       3
         *       /  \     /  \
         *      4    5    6    7
         *     / \  / \  / \  / \
         *    8  9 3   1 4  2 7  2
         *      /     / \    \
         *     16    17  18   19
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);

        root.left.right.left = new Node(3);
        root.left.right.right = new Node(1);

        root.right.left.left = new Node(4);
        root.right.left.right = new Node(2);

        root.right.right.left = new Node(7);
        root.right.right.right = new Node(2);

        root.left.left.right.left = new Node(16);
        root.left.right.right.left = new Node(17);
        root.left.right.right.right = new Node(18);
        root.right.left.right.right = new Node(19);

        traverse_boundary(root);
    }

    private static void traverse_boundary(Node root) {
        if(root == null) return;

        traverseLeftBoundary(root);
        traverse_leaf(root);
        traverseRightBoundary(root);

    }

    private static void traverseRightBoundary(Node root) {
        if (root == null) return;
        traverseRightBoundary(root.right);
        if (root.left != null && root.right != null)
            System.out.print(root.val + " ");
    }

    private static void traverse_leaf(Node root) {
        if(root==null) return;

        traverse_leaf(root.left);
        if(root.left==null & root.right==null)
            System.out.print(root.val+" ");
        traverse_leaf(root.right);
    }

    private static void traverseLeftBoundary(Node root) {
        if(root == null) return;
        if(root.left == null && root.right == null) return;
        System.out.print(root.val+" ");
        traverseLeftBoundary(root.left);
    }
}
