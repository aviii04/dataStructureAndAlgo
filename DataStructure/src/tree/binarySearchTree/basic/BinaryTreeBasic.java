package tree.binarySearchTree.basic;

import java.util.LinkedList;
import java.util.Queue;

class Node {
    int val;
    Node left;
    Node right;
    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree{
    Node root;

    private Node addRecursive(Node current, int val){
        if(current == null) return new Node(val);

        if(val < current.val){
            current.left = addRecursive(current.left, val);
        } else if (val > current.val){
            current.right = addRecursive(current.right, val);
        }
        return current;
    }

    public void addRecursive(int val){
        root = addRecursive(root, val);
    }

    //Depth first traversal
    public void preOrder(Node current){
        if(current != null){
            System.out.println(current.val);
            preOrder(current.left);
            preOrder(current.right);
        }
    }

    public void inOrder(Node current){
        if(current != null){
            inOrder(current.left);
            System.out.println(current.val);
            inOrder(current.right);
        }
    }

    public void postOrder(Node current){
        if(current != null){
            postOrder(current.left);
            postOrder(current.right);
            System.out.println(current.val);
        }
    }


    //Breadth first traversal
    public void traverseLevelOrder(Node current){
        if(current == null) return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(current);

        while(!queue.isEmpty()){
            Node node = queue.remove();
            System.out.println(node.val);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
        }
    }

}

class BinaryTreeBasic {

    public static void main(String[] args){

        /*  7
         /    \
        6       5
       / \     / \
      4  3     2  1         */

        // Add nodes
        BinaryTree  binaryTree = new BinaryTree();
        binaryTree.addRecursive(6);
        binaryTree.addRecursive(4);
        binaryTree.addRecursive(8);
        binaryTree.addRecursive(3);
        binaryTree.addRecursive(5);
        binaryTree.addRecursive(7);
        binaryTree.addRecursive(9);


//        binaryTree.inOrder(binaryTree.root);
        binaryTree.traverseLevelOrder(binaryTree.root);

    }


}
