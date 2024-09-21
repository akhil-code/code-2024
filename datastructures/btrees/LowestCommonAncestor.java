package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;

public class LowestCommonAncestor {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);

        BinaryTreeNode lca = findLCA(root, 4, 5);
        if (lca != null)
            System.out.println("LCA(4, 5) = " + lca.data);
        else
            System.out.println("Keys are not present");

        lca = findLCA(root,4, 7);
        if (lca != null)
            System.out.println("LCA(4, 7) = " + lca.data);
        else
            System.out.println("Keys are not present");
    }

    public static BinaryTreeNode findLCA(BinaryTreeNode root, int target1, int target2) {
        if(root == null) {
            return null;
        }
        if(root.data == target1 || root.data == target2) {
            return root;
        }

        BinaryTreeNode leftLCA = findLCA(root.left, target1, target2);
        BinaryTreeNode rightLCA = findLCA(root.right, target1, target2);

        if(leftLCA != null && rightLCA != null) {
            return root;
        } else if(leftLCA != null) {
            return leftLCA;
        } else if(rightLCA != null) {
            return rightLCA;
        }
        return null;
    }
}
