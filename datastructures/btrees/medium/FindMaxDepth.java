package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

public class FindMaxDepth {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        System.out.println(findMaxDepth(root));
    }

    public static int findMaxDepth(BinaryTreeNode node) {
        if(node == null) {
            return 0;
        }
        return Math.max(1 + findMaxDepth(node.left), 1 + findMaxDepth(node.right));
    }
}
