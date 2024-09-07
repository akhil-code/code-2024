package datastructures.bst;

import datastructures.btrees.model.BinaryTreeNode;

public class Search {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(50);
        root.left = new BinaryTreeNode(30);
        root.right = new BinaryTreeNode(70);
        root.left.left = new BinaryTreeNode(20);
        root.left.right = new BinaryTreeNode(40);
        root.right.left = new BinaryTreeNode(60);
        root.right.right = new BinaryTreeNode(80);

        // Searching for keys in the BST
        System.out.println(search(root, 19) != null
                ? "Found"
                : "Not Found");
        System.out.println(search(root, 80) != null
                ? "Found"
                : "Not Found");
    }
    
    public static BinaryTreeNode search(BinaryTreeNode node, int data) {
        if(node == null) {
            return null;
        }

        if(node.data == data) {
            return node;
        }

        if(data < node.data) {
            return search(node.left, data);
        } else {
            return search(node.right, data);
        }
    }
}
