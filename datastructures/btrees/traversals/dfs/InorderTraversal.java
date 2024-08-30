package datastructures.btrees.traversals.dfs;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        inorder(tree);
        System.out.println("\nInorder traversal using iterative");
        inorderIterative(tree);
    }

    public static void inorder(BinaryTreeNode node) {
        if(node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + " -> ");
        inorder(node.right);
    }

    public static void inorderIterative(BinaryTreeNode node) {
        BinaryTreeNode currNode = node;
        Stack<BinaryTreeNode> stack = new Stack<>();
        while(currNode != null || !stack.isEmpty()) {
            while(currNode != null) {
                stack.add(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            System.out.print(currNode.data + " -> ");
            currNode = currNode.right;
        }
    }
}
