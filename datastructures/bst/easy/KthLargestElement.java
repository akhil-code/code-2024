package datastructures.bst.easy;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class KthLargestElement {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(3);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(10);

        System.out.println(kthLargestElement(root, 2).data);
    }

    public static BinaryTreeNode kthLargestElement(BinaryTreeNode root, int k) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currNode = root;

        while(!stack.isEmpty() || currNode != null) {
            while(currNode != null) {
                stack.add(currNode);
                currNode = currNode.right;
            }
            currNode = stack.pop();
            k--;
            if(k == 0) {
                return currNode;
            }
            currNode = currNode.left;
        }
        return null;
    }
}
