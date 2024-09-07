package datastructures.bst.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class FindSumPair {
    public static void main(String[] args) {
        // Constructing the following BST:
        //         7
        //        / \
        //       3   8
        //      / \   \
        //     2   4   9

        BinaryTreeNode root = new BinaryTreeNode(7);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(8);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.right.right = new BinaryTreeNode(9);

        int sum = 10;

        SumPair output = findTarget(root, sum);
        if(output != null) {
            System.out.println(output.node1.data + ", " + output.node2.data);
        } else {
            System.out.println("No match found");
        }
    }

    public static SumPair findTarget(BinaryTreeNode root, int targetSum) {
        // start and last node of tree
        BinaryTreeNode firstNode = root;
        BinaryTreeNode secondNode = root;
        // stacks for inorder traversals
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();
        boolean moveLeft = true;
        boolean moveRight = true;
        while(true) {
            if(moveLeft) {
                while(firstNode != null && moveLeft) {
                    stack1.add(firstNode);
                    firstNode = firstNode.left;
                }
                firstNode = stack1.pop();
            }

            if(moveRight) {
                while(secondNode != null && moveRight) {
                    stack2.add(secondNode);
                    secondNode = secondNode.right;
                }
                secondNode = stack2.pop();
            }
            int diff = targetSum - (firstNode.data + secondNode.data);
            if(firstNode == secondNode) {
                return null;
            }

            if(diff > 0) {
                firstNode = firstNode.right;
                moveLeft = true;
                moveRight = false;
            } else if(diff < 0) {
                secondNode = secondNode.left;
                moveLeft = false;
                moveRight = true;
            } else {
                return new SumPair(firstNode, secondNode);
            }
        }
    }

    private static BinaryTreeNode findStartNode(BinaryTreeNode root) {
        while(root != null && root.left != null) {
            root = root.left;
        }
        return root;
    }

    private static BinaryTreeNode findLastNode(BinaryTreeNode root) {
        while(root != null && root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static class SumPair {
        BinaryTreeNode node1;
        BinaryTreeNode node2;

        public SumPair(BinaryTreeNode node1, BinaryTreeNode node2) {
            this.node1 = node1;
            this.node2 = node2;
        }
    }
}
