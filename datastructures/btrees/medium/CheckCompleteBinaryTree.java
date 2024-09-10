package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class CheckCompleteBinaryTree {

    public static void main(String args[])
    {
        BinaryTreeNode tree = new BinaryTreeNode(1);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(3);
        tree.left.right = new BinaryTreeNode(5);
        tree.left.left = new BinaryTreeNode(4);
        tree.right.right = new BinaryTreeNode(7);


        if (isCompleteBinaryTree(tree))
            System.out.print("The binary tree is complete");
        else
            System.out.print("The binary tree is not complete");
    }

    public static boolean isCompleteBinaryTree(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean foundLeafNode = false;

        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.poll();
            if(currNode.left != null) {
                queue.add(currNode.left);
                if(foundLeafNode) {
                    return false;
                }
            } else {
                foundLeafNode = true;
            }

            if(currNode.right != null) {
                queue.add(currNode.right);
                if(foundLeafNode) {
                    return false;
                }
            } else {
                foundLeafNode = true;
            }
        }
        return true;
    }
}
