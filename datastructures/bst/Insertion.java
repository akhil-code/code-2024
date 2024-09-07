package datastructures.bst;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.dfs.InorderTraversal;

public class Insertion {
    public static void main(String[] args)
    {
        BinaryTreeNode root = null;
        root = insert(root, 50);
        root = insert(root, 30);
        root = insert(root, 20);
        root = insert(root, 40);
        root = insert(root, 70);
        root = insert(root, 60);
        root = insert(root, 80);

        // Print inorder traversal of the BST
        InorderTraversal.inorder(root);
    }

    public static BinaryTreeNode insert(BinaryTreeNode root, int data) {
        if(root == null) {
            return new BinaryTreeNode(data);
        }
        if(data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }
}
