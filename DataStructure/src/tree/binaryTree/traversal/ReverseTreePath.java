package tree.binaryTree.traversal;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://www.geeksforgeeks.org/reverse-tree-path/">Reverse Tree Path</a>
 */

public class ReverseTreePath {

    static class Node {
        int val;
        Node left;
        Node right;

        Node(int val) {
            this.val = val;
        }
    }

    static int pos = 0;

    public static void main(String[] args) {
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

        printInOrder(root);
        System.out.println();

        int data = 4;
        boolean isReversed = reverseTreePath(root, data);
        if (isReversed) {
            System.out.println("Reversed:");
            printInOrder(root);
        } else {
            System.out.println("Give value not found:");
        }
    }

    private static boolean reverseTreePath(Node root, int data) {
        Map<Integer, Integer> levelToValue = new HashMap<>();
        int treeLevel = 0;
        boolean reverseExist = reverseTreePathUtil(root, data, levelToValue, treeLevel);
        return reverseExist;
    }

    private static boolean reverseTreePathUtil(Node current, int data, Map<Integer, Integer> levelToValue, int level) {

        if (current == null) return false;

        levelToValue.put(level, current.val);

        if (current.val == data) {
            current.val = levelToValue.get(pos);
            pos++;
            return true;
        }

        if (reverseTreePathUtil(current.left, data, levelToValue, level + 1)) {
            current.val = levelToValue.get(pos);
            pos++;
            return true;
        }

        if (reverseTreePathUtil(current.right, data, levelToValue, level + 1)) {
            current.val = levelToValue.get(pos);
            pos++;
            return true;
        }

        levelToValue.remove(level);
        return false;
    }

    private static void printInOrder(Node root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(" " + root.val);
            printInOrder(root.right);
        }
    }

}
