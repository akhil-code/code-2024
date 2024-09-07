package datastructures.bst.medium;


import datastructures.btrees.model.BinaryTreeNode;

public class LCAInBST {
    public static void main(String args[]) {
        BinaryTreeNode tree = new BinaryTreeNode(20);
        tree.left = new BinaryTreeNode(8);
        tree.right = new BinaryTreeNode(22);
        tree.left.left = new BinaryTreeNode(4);
        tree.left.right = new BinaryTreeNode(12);
        tree.left.right.left = new BinaryTreeNode(10);
        tree.left.right.right = new BinaryTreeNode(14);

        // Test calls
        int n1 = 10, n2 = 14;
        BinaryTreeNode t = lcaInBST(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 14;
        n2 = 8;
        t = lcaInBST(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);

        n1 = 10;
        n2 = 22;
        t = lcaInBST(tree, n1, n2);
        System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);
    }

    public static BinaryTreeNode lcaInBST(BinaryTreeNode root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        if(n1 == root.data || n2 == root.data) {
            return root;
        }

        if(n1 < root.data && n2 < root.data) {
            return lcaInBST(root.left, n1, n2);
        } else if(n1 > root.data && n2 > root.data) {
            return lcaInBST(root.right, n1, n2);
        } else {
            BinaryTreeNode leftLca = lcaInBST(root.left, n1, n2);
            BinaryTreeNode rightLca = lcaInBST(root.right, n1, n2);
            if(leftLca != null && rightLca != null) {
                return root;
            } else if(leftLca != null) {
                return leftLca;
            } else {
                return rightLca;
            }
        }
    }

}
