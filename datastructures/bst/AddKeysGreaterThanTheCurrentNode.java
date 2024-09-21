package datastructures.bst;

import datastructures.bst.Insertion;
import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;
import datastructures.btrees.traversals.dfs.InorderTraversal;

import java.util.Stack;

public class AddKeysGreaterThanTheCurrentNode {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        /* Let us create following BST
           8
         /     \
   5     12
  / \   / \
 2   7 9   15   */

        root = Insertion.insert(root, 5);
        root = Insertion.insert(root, 2);
        root = Insertion.insert(root, 7);
        root = Insertion.insert(root, 12);
        root = Insertion.insert(root, 9);
        root = Insertion.insert(root, 15);

        addGreaterKeys(root);
        InorderTraversal.inorder(root);
    }

    public static void addGreaterKeys(BinaryTreeNode node) {
        // inorder reverse
        BinaryTreeNode currNode = node;
        Stack<BinaryTreeNode> stack = new Stack<>();
        int currSum = 0;

        while(!stack.isEmpty() || currNode != null) {
            while(currNode != null) {
                stack.add(currNode);
                currNode = currNode.right;
            }

            currNode = stack.pop();
            currNode.data += currSum;
            currSum = currNode.data;
            currNode = currNode.left;
        }
    }
}
