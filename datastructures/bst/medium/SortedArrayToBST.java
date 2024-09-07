package datastructures.bst.medium;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;

public class SortedArrayToBST {
    public static void main(String[] args) {
        // create a sorted array
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        BinaryTreeNode root = sortedArrayToBST(nums, 0, nums.length - 1);
        LevelOrderTraversal.levelOrderTraversal(root);
    }

    public static BinaryTreeNode sortedArrayToBST(int[] arr, int l, int r) {
        if(l <= r) {
            int m = (l + r) / 2;
            BinaryTreeNode node = new BinaryTreeNode(arr[m]);
            node.left = sortedArrayToBST(arr, l, m-1);
            node.right = sortedArrayToBST(arr, m+1, r);
            return node;
        }
        return null;
    }
}
