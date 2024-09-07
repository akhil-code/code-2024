package datastructures.bst;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.dfs.InorderTraversal;

public class Deletion {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(15);
        root.right.left = new BinaryTreeNode(12);
        root.right.right = new BinaryTreeNode(18);

        root = deleteNode(root, 15);
        InorderTraversal.inorder(root);
    }

    public static BinaryTreeNode deleteNode(BinaryTreeNode node, int target) {
        if(node == null) {
            return null;
        }
        if(target < node.data) {
            node.left = deleteNode(node.left, target);
            return node;
        } else if (target > node.data) {
            node.right = deleteNode(node.right, target);
            return node;
        }

        if(BTreeUtil.isLeafNode(node)) {
            return null;
        } else if(BTreeUtil.hasOneChildren(node)) {
            if(node.left != null) {
                return node.left;
            } else {
                return node.right;
            }
        } else {
            BinaryTreeNode nextNode = findNextNode(node);
            node.data = nextNode.data;
            node.right = deleteNode(node.right, nextNode.data);
        }
        return node;
    }


    private static BinaryTreeNode findNextNode(BinaryTreeNode node) {
        node = node.right;
        while(node != null && node.left != null) {
            node = node.left;
        }
        return node;
    }
}
