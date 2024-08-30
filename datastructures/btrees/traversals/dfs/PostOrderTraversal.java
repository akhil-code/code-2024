package datastructures.btrees.traversals.dfs;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        postOrderTraversal(tree);
        System.out.println("\nPost order traversal using iteration");

        postOrderIterative(tree);
    }

    public static void postOrderTraversal(BinaryTreeNode node) {
        if(node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " -> ");
    }

    public static void postOrderIterative(BinaryTreeNode tree) {
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.add(tree);
        while(!stack1.isEmpty()) {
            BinaryTreeNode currNode = stack1.pop();
            stack2.add(currNode);
            if(currNode.left != null) {
                stack1.add(currNode.left);
            }
            if(currNode.right != null) {
                stack1.add(currNode.right);
            }
        }

        while(!stack2.isEmpty()) {
            BinaryTreeNode currNode = stack2.pop();
            System.out.print(currNode.data + " -> ");
        }
    }
}
