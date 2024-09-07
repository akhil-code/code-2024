package datastructures.bst.medium;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CheckSortedSubsequenceExistsInBST {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(5);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(4);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(8);

        // check if a given sorted sub-sequence exists in the BST 
        List<Integer> seq1 = new ArrayList<>();
        seq1.add(2);
        seq1.add(3);
        seq1.add(4);

        if (existsSubsequence(root, seq1)) {
            System.out.println("The sequence {2, 3, 4} exists in the BST");
        } else {
            System.out.println("The sequence {2, 3, 4} does not exist in the BST");
        }
    }

    public static boolean existsSubsequence(BinaryTreeNode root, List<Integer> sequence) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currNode = root;
        int seqIndex = 0;
        while(!stack.isEmpty() || currNode != null) {
            while(currNode != null) {
                stack.add(currNode);
                currNode = currNode.left;
            }
            currNode = stack.pop();
            // move sequence to next element
            if(currNode.data == sequence.get(seqIndex)) {
                seqIndex++;
            } else if(currNode.data > sequence.get(seqIndex)) {
                return false;
            }

            if(seqIndex >= sequence.size()) {
                return true;
            }
            currNode = currNode.right;

        }

        return false;
    }
}
