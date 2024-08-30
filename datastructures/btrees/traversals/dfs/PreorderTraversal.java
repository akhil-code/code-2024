package datastructures.btrees.traversals.dfs;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class PreorderTraversal {

    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        preOrder(tree);
        System.out.println("\niterative traversal");
        preorderRecursive(tree);
    }
    public static void preOrder(BinaryTreeNode node) {
        if(node == null) {
            return;
        }
        System.out.print(node.data + " -> ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void preorderRecursive(BinaryTreeNode node) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.add(node);
        while(!stack.isEmpty()) {
            BinaryTreeNode currNode = stack.pop();
            System.out.print(currNode.data + " -> ");
            if(currNode.right != null) {
                stack.add(currNode.right);
            }
            if(currNode.left != null) {
                stack.add(currNode.left);
            }
        }
    }
}
