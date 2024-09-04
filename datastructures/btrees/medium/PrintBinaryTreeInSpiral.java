package datastructures.btrees.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class PrintBinaryTreeInSpiral {

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(6);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(4);
        spiralTraversal(root);
    }

    public static void spiralTraversal(BinaryTreeNode root) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Stack<Integer> stack = new Stack<>();
        queue.add(root);
        boolean leftToRight = false;

        int levelSize = queue.size();
        while(!queue.isEmpty()) {

            BinaryTreeNode currNode = queue.poll();

            if (leftToRight) {
                System.out.print(currNode + " -> ");
            } else {
                stack.add(currNode.data);
            }

            levelSize--;

            if(currNode.left != null) {
                queue.add(currNode.left);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
            }


            if(levelSize == 0) {
                levelSize = queue.size();
                if(!leftToRight) {
                    printStack(stack);
                    stack.empty();
                }
                System.out.println("");
                leftToRight = ! leftToRight;

            }
        }
    }

    private static void printStack(Stack<Integer> stack) {
        while(!stack.isEmpty()) {
            System.out.print(stack.pop() + " -> ");
        }
    }
}
