package tree.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/level-order-tree-traversal/">Level order Traversal</a>
 */
public class LevelOrderTraversal {
    
    static class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }
    
    public static void main(String[] args){
        
        /*  7
         /    \
        6       5
       / \     / \
      4  3     2  1         */

        Node root = new Node(7);
        root.left = new Node(6);
        root.left.left = new Node(4);
        root.left.right = new Node(3);
        root.right = new Node(5);
        root.right.left = new Node(2);
        root.right.right = new Node(1);

        printLevelOrder_Queue(root);
        printLevelOrder_Function(root);
        printLevelOrder_Spiral(root);

    }

    /**
     * <a href="https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/">Level Order Spiral Traversal</a>
     * @param root
     */
    private static void printLevelOrder_Spiral(Node root) {
        System.out.println("\n Printing in Spiral Form: ");
        if (root == null) return;

        Stack<Node> stack_left_to_right = new Stack<>();
        Stack<Node> stack_right_to_left = new Stack<>();

        stack_right_to_left.push(root);
        Node current;
        while (!stack_left_to_right.isEmpty() || !stack_right_to_left.isEmpty()) {

            while (!stack_right_to_left.isEmpty()) {
                current = stack_right_to_left.pop();
                System.out.print(" " + current.val);

                if (current.left != null) stack_left_to_right.push(current.left);
                if (current.right != null) stack_left_to_right.push(current.right);
            }

            while (!stack_left_to_right.isEmpty()) {
                current = stack_left_to_right.pop();
                System.out.print(" " + current.val);

                if (current.right != null) stack_right_to_left.push(current.right);
                if (current.left != null) stack_right_to_left.push(current.left);
            }
        }
    }

    /**
     * Using function calls to iterate and print.
     * @param root
     */
    private static void printLevelOrder_Function(Node root) {
        int height = findTreeHeight(root);
        System.out.println();
        System.out.println("Height of Tree: " + height);
        if (height != 0) {
            printLevelOrder(root, height);
        }
    }

    private static void printLevelOrder(Node root, int height) {
        for(int level = 1; level<=height; level++){
            printCurrentLevel(root, level);
        }
    }

    private static void printCurrentLevel(Node current, int level) {
        if(current == null) return;

        if(level == 1){
            System.out.print(current.val + " ");
        } else {
            printCurrentLevel(current.left, level-1);
            printCurrentLevel(current.right, level-1);
        }

    }

    private static int findTreeHeight(Node root) {
        if (root == null) return 0;
        int leftSubTreeHeight = findTreeHeight(root.left);
        int rightSubTreeHeight = findTreeHeight(root.right);
        return 1 + Math.max(leftSubTreeHeight, rightSubTreeHeight);
    }

    /**
     * Using Queue Data structure (Extra space)
     * @param root
     */
    private static void printLevelOrder_Queue(Node root) {

        if(root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.print(" "+current.val);

            if(current.left!=null) queue.add(current.left);
            if(current.right!=null) queue.add(current.right);
        }
    }
}
