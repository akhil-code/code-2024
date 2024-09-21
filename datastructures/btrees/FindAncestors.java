package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.List;
import java.util.Stack;

public class FindAncestors {
    public static void main(String[] args) {
        /* Construct the following binary tree
                  1
                /   \
               2     3
              /  \
             4    5
            /
           7
        */
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.left.left.left = new BinaryTreeNode(7);

        List<Integer> ancestors = printAncestors(root, 5);
        System.out.println(ancestors);
    }

    private static List<Integer> printAncestorsUtil(BinaryTreeNode node, int target, Stack<Integer> stack) {
        if(node == null) {
            return null;
        }

        if(target == node.data) {
            return stack.stream().toList();
        }

        if(node.left != null) {
            stack.add(node.left.data);
            List<Integer> output = printAncestorsUtil(node.left, target, stack);
            stack.pop();

            if(output != null) {
                return output;
            }
        }

        if(node.right != null) {
            stack.add(node.right.data);
            List<Integer> output = printAncestorsUtil(node.right, target, stack);
            stack.pop();
            if(output != null) {
                return output;
            }
        }
        return null;
    }

    public static List<Integer> printAncestors(BinaryTreeNode node, int target) {
        Stack<Integer> stack = new Stack<>();
        stack.add(node.data);
        return printAncestorsUtil(node, target, stack);
    }
}
