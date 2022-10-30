package tree.binaryTree.traversal;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * <a href="https://www.geeksforgeeks.org/level-order-tree-traversal/">Level order Traversal</a>
 */
public class LevelOrderTraversal {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

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
        root.left.right.left.left = new Node(16);
        root.left.right.left.right = new Node(17);
        root.right.left.right.left = new Node(18);
        root.right.right.left.right = new Node(19);

        printLevelOrder_Queue(root);
        printLevelOrder_Function(root);
        printLevelOrder_Spiral(root);
        printLevelOrder_LineByLine(root);
        printLevelOrder_DirectionChange_After_Two_Level(root);
        printLevelOrder_Bottom_Up(root);

    }

    /**
     * <a href="https://www.geeksforgeeks.org/reverse-level-order-traversal/">Level Order - Bottom Up</a>
     * @param root
     */
    private static void printLevelOrder_Bottom_Up(Node root) {
        System.out.print("\n Level Order Bottom Up:");
        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.add(root);
        queue.add(null);

        Node current;
        while (!queue.isEmpty()) {
            current = queue.remove();

            if (current != null) {

                if (current.right != null) queue.add(current.right);
                if (current.left != null) queue.add(current.left);

                if (queue.peek() == null) queue.add(null);
            }
            stack.push(current);
        }

        // Print stack content
        while (!stack.isEmpty()) {
            current = stack.pop();
            if (current != null) {
                System.out.print(current.val + " ");
            } else {
                System.out.println();
            }

        }

    }

    /**
     * <a href="https://www.geeksforgeeks.org/level-order-traversal-direction-change-every-two-levels/">Level Order - Direction Change after Two Levels</a>
     *
     * @param root
     */
    private static void printLevelOrder_DirectionChange_After_Two_Level(Node root) {
        System.out.println("Direction change after every two level:");

        if (root == null) return;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        boolean rightToLeft = false;
        int directionChangeLevel = 2;
        int treeLevel = 1;

        queue.add(root);

        Node current;
        while (!queue.isEmpty()) {

            int elementsInLevel = queue.size();
            for (int i = 0; i < elementsInLevel; i++) {

                current = queue.remove();
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                if (rightToLeft) {
                    stack.add(current);
                } else {
                    System.out.print(current.val + " ");
                }

            }

            while (!stack.isEmpty()) {
                System.out.print(stack.pop().val + " ");
            }

            if ((treeLevel) % directionChangeLevel == 0) rightToLeft = !rightToLeft;
            treeLevel++;
            System.out.println();
        }

    }

    /**
     * <a href="https://www.geeksforgeeks.org/level-order-traversal-line-line-set-3-using-one-queue/">Level Order Line By Line</a>
     *
     * @param root
     */
    private static void printLevelOrder_LineByLine(Node root) {
        System.out.println("\n Level Order Line by Line:");
        if (root == null) return;

        // Adding null in queue as delimiter to identify next level.
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        Node current;
        while (!queue.isEmpty()) {

            current = queue.remove();
            if (current != null) {

                System.out.print(current.val + " ");
                if (current.left != null) queue.add(current.left);
                if (current.right != null) queue.add(current.right);

                if (queue.peek() == null) queue.add(null);

            } else {
                System.out.println();
            }
        }
    }

    /**
     * <a href="https://www.geeksforgeeks.org/level-order-traversal-in-spiral-form/">Level Order Spiral Traversal</a>
     *
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
     *
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
        for (int level = 1; level <= height; level++) {
            printCurrentLevel(root, level);
        }
    }

    private static void printCurrentLevel(Node current, int level) {
        if (current == null) return;

        if (level == 1) {
            System.out.print(current.val + " ");
        } else {
            printCurrentLevel(current.left, level - 1);
            printCurrentLevel(current.right, level - 1);
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
     *
     * @param root
     */
    private static void printLevelOrder_Queue(Node root) {

        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node current = queue.remove();
            System.out.print(" " + current.val);

            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }
}
