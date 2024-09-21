package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;

public class DistanceBetweenTwoNodes {
    public static void main(String[] args) {
        // Let us create binary tree
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.right = new BinaryTreeNode(8);
        System.out.println("Dist(4, 5) = "
                + findDistance(root, 4, 5));

        System.out.println("Dist(4, 6) = "
                + findDistance(root, 4, 6));

        System.out.println("Dist(3, 4) = "
                + findDistance(root, 3, 4));

        System.out.println("Dist(2, 4) = "
                + findDistance(root, 2, 4));

        System.out.println("Dist(8, 5) = "
                + findDistance(root, 8, 5));
    }

    public static int findDepth(BinaryTreeNode root, int target, int currDepth) {
        if(root == null) {
            return -1;
        }
        if(root.data == target) {
            return currDepth;
        }

        int leftDepth = findDepth(root.left, target, 1 + currDepth);
        int rightDepth = findDepth(root.right, target, 1 + currDepth);
        return Math.max(leftDepth, rightDepth);
    }

    public static int findDistance(BinaryTreeNode node, int target1, int target2) {
        BinaryTreeNode lca = LowestCommonAncestor.findLCA(node, target1, target2);
        // depth 1
        int d1 = findDepth(lca, target1, 0);
        // depth 2
        int d2 = findDepth(lca, target2, 0);
        return d1 + d2;
    }
}
