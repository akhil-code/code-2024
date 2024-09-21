package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TopViewOfTree {
    public static void main(String args[]) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.right = new BinaryTreeNode(4);
        root.left.right.right = new BinaryTreeNode(5);
        root.left.right.right.right = new BinaryTreeNode(6);
        topView(root);
    }

    public static void topView(BinaryTreeNode tree) {
        Queue<HDNode> queue = new LinkedList<>();
        queue.add(new HDNode(tree, 0));

        Map<Integer, Integer> hdMap = new HashMap<>();
        int minSoFar = Integer.MAX_VALUE;
        int maxSoFar = Integer.MIN_VALUE;

        while(!queue.isEmpty()) {
            HDNode currHDNode = queue.poll();
            hdMap.putIfAbsent(currHDNode.hd, currHDNode.treeNode.data);
            minSoFar = Math.min(minSoFar, currHDNode.hd);
            maxSoFar = Math.max(maxSoFar, currHDNode.hd);

            if(currHDNode.treeNode.left != null) {
                queue.add(new HDNode(currHDNode.treeNode.left, currHDNode.hd - 1));
            }
            if(currHDNode.treeNode.right != null) {
                queue.add(new HDNode(currHDNode.treeNode.right, currHDNode.hd + 1));
            }
        }

        for (int i = minSoFar; i <= maxSoFar; i++) {
            System.out.print(hdMap.get(i) + ", ");
        }
    }

    static class HDNode {
        BinaryTreeNode treeNode;
        int hd;

        public HDNode(BinaryTreeNode treeNode, int hd) {
            this.treeNode = treeNode;
            this.hd = hd;
        }
    }
}
