package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.dfs.InorderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderInsertion {// Driver code
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(11);
        root.left.left = new BinaryTreeNode(7);
        root.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(15);
        root.right.right = new BinaryTreeNode(8);

        System.out.print("Inorder traversal before insertion:");
        InorderTraversal.inorder(root);

        int key = 12;
        insert(root, key);

        System.out.print("\nInorder traversal after insertion:");
        InorderTraversal.inorder(root);
    }

    public static void insert(BinaryTreeNode root, int data) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.poll();

            if(currNode.left == null) {
                currNode.left = new BinaryTreeNode(data);
                return;
            } else {
                queue.add(currNode.left);
            }

            if(currNode.right == null) {
                currNode.right = new BinaryTreeNode(data);
            } else {
                queue.add(currNode.right);
            }
        }
    }
}
