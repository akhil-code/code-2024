package datastructures.bst;

import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.dfs.InorderTraversal;

import java.util.Arrays;
import java.util.List;

public class ConstructBSTFromPreorder {

    public static void main(String[] args) {
        List<Integer> preorder = Arrays.asList(4,2,1,3,6,5,7);
        BinaryTreeNode tree = constructBSTFromPreorder(preorder);
        InorderTraversal.inorder(tree);
    }
    public static BinaryTreeNode constructBSTFromPreorder(List<Integer> preorder) {
        Pair response = util(preorder, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        return response.node;
    }

    public static Pair util(List<Integer> preorder, int i, int minValue, int maxValue) {
        if(i >= preorder.size()) {
            return new Pair(null, i);
        }

        if(preorder.get(i) < minValue || preorder.get(i) > maxValue) {
            return new Pair(null, i);
        }

        BinaryTreeNode newNode = new BinaryTreeNode(preorder.get(i));
        Pair leftPair = util(preorder, i+1, minValue, preorder.get(i));
        newNode.left = leftPair.node;

        Pair rightPair = util(preorder, leftPair.index, preorder.get(i), maxValue);
        newNode.right = rightPair.node;

        return new Pair(newNode, rightPair.index);
    }

    static class Pair {
        BinaryTreeNode node;
        Integer index;

        public Pair(BinaryTreeNode node, Integer index) {
            this.node = node;
            this.index = index;
        }
    }
}
