package datastructures.bst;

import datastructures.bst.Insertion;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.Stack;

public class KthSmallestElement {
    public static void main(String[] args) {
        BinaryTreeNode root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };

        for (int x : keys)
            root = Insertion.insert(root, x);

        int k = 4;
        BinaryTreeNode res = kthSmallest(root, k);
        if (res == null)
            System.out.println("There are less than k nodes in the BST");
        else
            System.out.println("K-th Smallest Element is " + res.data);
    }

    public static BinaryTreeNode kthSmallest(BinaryTreeNode root, int k) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currNode = root;
        while(!stack.isEmpty() || currNode != null) {
            while(currNode != null) {
                stack.add(currNode);
                currNode = currNode.left;
            }

            currNode = stack.pop();
            k--;
            if(k == 0) {
                return currNode;
            }

            currNode = currNode.right;
        }
        return null;
    }
}
