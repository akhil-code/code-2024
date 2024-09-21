package datastructures.bst;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;
import datastructures.btrees.traversals.dfs.InorderTraversal;

public class CheckIfTreeIsBST {
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(5);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(3);

        // Function call
        if (isBST(root)) {
            System.out.println("Is BST");
        } else {
            System.out.println("Not a BST");
        }

        InorderTraversal.inorder(root);
    }

    public static boolean isBST(BinaryTreeNode node) {
        return util(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean util(BinaryTreeNode node, int minValue, int maxValue) {
        if(node == null) {
            return true;
        }
        return (node.data >= minValue && node.data <= maxValue)
                && util(node.left, minValue, node.data)
                && util(node.right, node.data, maxValue);
    }
}
