package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;

public class BTreeUtil {
    public static BinaryTreeNode createDummyTree() {
        // level 0
        BinaryTreeNode rootNode = new BinaryTreeNode(1);

        //level 1
        rootNode.left = new BinaryTreeNode(2);
        rootNode.right = new BinaryTreeNode(3);

        // level 2
        rootNode.left.left = new BinaryTreeNode(4);
        rootNode.left.right = new BinaryTreeNode(5);
        rootNode.right.left = new BinaryTreeNode(6);
        rootNode.right.right = new BinaryTreeNode(7);

        // level 3
        rootNode.left.left.right = new BinaryTreeNode(8);
        rootNode.right.left.left = new BinaryTreeNode(9);
        rootNode.right.left.right = new BinaryTreeNode(10);

        return rootNode;
    }

    public static boolean isLeafNode(BinaryTreeNode node) {
        return node.left == null && node.right == null;
    }

    public static boolean hasOneChildren(BinaryTreeNode node) {
        return !isLeafNode(node) && !hasTwoChildren(node);
    }

    public static boolean hasTwoChildren(BinaryTreeNode node) {
        return node.left != null && node.right != null;
    }


}
