package datastructures.btrees.easy;

import java.util.Arrays;

public class PostOrderFromInorderAndPreorder {
    public static void main(String[] args) {
        int[] inorder = {4, 2, 7, 5, 8, 1, 3, 6};
        int[] preorder = {1, 2, 4, 5, 7, 8, 3, 6};
        postOrderFromInorderAndPreorder(inorder, preorder);
    }

    public static void postOrderFromInorderAndPreorder(int[] inorder, int[] preorder) {
        int n = inorder.length;
        if(n <= 0) {
            return;
        }

        // find root
        int rootIndex = findRoot(inorder, preorder[0]);
        // left subtree
        if(rootIndex != 0) {
            postOrderFromInorderAndPreorder(Arrays.copyOfRange(inorder, 0, rootIndex), Arrays.copyOfRange(preorder, 1, rootIndex + 1));
        }
        // right subtree
        if(rootIndex != n - 1) {
            postOrderFromInorderAndPreorder(Arrays.copyOfRange(inorder, rootIndex + 1, n), Arrays.copyOfRange(preorder, rootIndex + 1, n));
        }

        System.out.print(preorder[0] + " -> ");
    }

    private static int findRoot(int[] inorder, int preorder) {
        int root = -1;
        for (int i = 0; i < inorder.length; i++) {
            if(preorder == inorder[i]) {
                return i;
            }
        }
        return root;
    }
}
