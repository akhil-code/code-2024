package datastructures.btrees.easy;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class IdenticalLeafTraversals {
    public static void main(String[] args) {
        BinaryTreeNode root1 = new BinaryTreeNode(1);
        root1.left = new BinaryTreeNode(2);
        root1.right = new BinaryTreeNode(3);
        root1.left.left = new BinaryTreeNode(4);
        root1.right.left = new BinaryTreeNode(6);
        root1.right.right = new BinaryTreeNode(7);

        BinaryTreeNode root2 = new BinaryTreeNode(0);
        root2.left = new BinaryTreeNode(1);
        root2.right = new BinaryTreeNode(5);
        root2.left.right = new BinaryTreeNode(4);
        root2.right.left = new BinaryTreeNode(6);
        root2.right.right = new BinaryTreeNode(7);

        boolean identical = identicalLeafTraversals(root1, root2);
        System.out.println("identical leaf traversals: " + identical);

    }

    public static boolean identicalLeafTraversals(BinaryTreeNode tree1, BinaryTreeNode tree2) {
        Stack<BinaryTreeNode> s1 = new Stack<>();
        Stack<BinaryTreeNode> s2 = new Stack<>();

        BinaryTreeNode currNode1 = null;
        BinaryTreeNode currNode2 = null;

        s1.add(tree1);
        s2.add(tree2);

        while(!s1.isEmpty() && !s2.isEmpty()) {
            while(!s1.isEmpty()) {
                currNode1 = s1.pop();
                if(currNode1.right != null) {
                    s1.add(currNode1.right);
                }
                if (currNode1.left != null) {
                    s1.add(currNode1.left);
                }

                if(currNode1.left == null && currNode1.right == null) {
                    break;
                }
            }

            while(!s2.isEmpty()) {
                currNode2 = s2.pop();

                if(currNode2.right != null) {
                    s2.add(currNode2.right);
                }
                if(currNode2.left != null) {
                    s2.add(currNode2.left);
                }
                if(currNode2.left == null && currNode2.right == null) {
                    break;
                }
            }

            System.out.println(String.format("curr1: %s, curr2: %s", currNode1.data, currNode2.data));
            if(currNode1.data != currNode2.data) {
                return false;
            }
        }
        return true;
    }
}
