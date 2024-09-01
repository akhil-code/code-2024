package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class BoundaryTraversal {
    public static void main(String[] args) {
        // Creating the binary tree
        BinaryTreeNode root = new BinaryTreeNode(20);
        root.left = new BinaryTreeNode(8);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(12);
        root.left.right.left = new BinaryTreeNode(10);
        root.left.right.right = new BinaryTreeNode(14);
        root.right = new BinaryTreeNode(22);
        root.right.right = new BinaryTreeNode(25);
        boundaryTraversal(root);
    }


    public static void boundaryTraversal(BinaryTreeNode tree) {
        List<Integer> output = new ArrayList<>();
        leftTraversal(tree, output);
        leafTraversal(tree, output);
        rightTraversal(tree.right, output);
        System.out.println("Boundary traversal: " + output);
    }

    private static void leftTraversal(BinaryTreeNode node, List<Integer> output) {
        while(node != null) {
            if(node.left == null && node.right == null) {
                return;
            }
            output.add(node.data);
            if(node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
    }

    private static void leafTraversal(BinaryTreeNode node, List<Integer> output) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(node);
        while (!stack.isEmpty()) {
            BinaryTreeNode currNode = stack.pop();
            if(currNode.right != null) {
                stack.add(currNode.right);
            }
            if(currNode.left != null) {
                stack.add(currNode.left);
            }

            if(currNode.left == null && currNode.right == null) {
                output.add(currNode.data);
            }
        }
    }

    private static void rightTraversal(BinaryTreeNode node, List<Integer> output) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(node != null) {
            if(node.left == null && node.right == null) {
                break;
            }

            output.add(node.data);
            if(node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }

        }
    }
}
