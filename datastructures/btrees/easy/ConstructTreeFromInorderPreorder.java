package datastructures.btrees.easy;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;
import datastructures.btrees.traversals.dfs.InorderTraversal;

import java.util.Arrays;

public class ConstructTreeFromInorderPreorder {
    public static void main(String[] args) {

        int in[] = new int[] { 9, 8, 4, 2, 10, 5, 10, 1, 6, 3, 13, 12, 7 };
        int pre[] = new int[] { 1, 2, 4, 8, 9, 5, 10, 10, 3, 6, 7, 12, 13 };
        // LevelOrderTraversal.levelOrderTraversal(constructTree(in, pre));
        InorderTraversal.inorder(constructTree(in, pre));
    }

    public static BinaryTreeNode constructTree(int[] inorder, int[] preorder) {
        int n = inorder.length;
        if(n <= 0) {
            return null;
        }
        // find root
        int rootIndex = findRoot(inorder, preorder[0]);
        BinaryTreeNode node = new BinaryTreeNode(preorder[0]);
        // construct left tree
        if(rootIndex != 0) {
            node.left = constructTree(Arrays.copyOfRange(inorder, 0, rootIndex), Arrays.copyOfRange(preorder, 1, rootIndex+1));
        }

        // construct right tree
        if (rootIndex != n-1) {
            node.right = constructTree(Arrays.copyOfRange(inorder, rootIndex + 1, n), Arrays.copyOfRange(preorder, rootIndex+1, n));
        }
        return node;
    }

    private static int findRoot(int[] inorder, int rootData) {
        for (int i = 0; i < inorder.length; i++) {
            if(rootData == inorder[i]) {
                return i;
            }
        }
        return -1;
    }
}
