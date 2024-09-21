package datastructures.btrees;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.*;

public class VerticalTraversalOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(5);
        root.right.left = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(7);
        root.right.left.right = new BinaryTreeNode(8);
        root.right.right.right = new BinaryTreeNode(9);
        verticalTraversal(root);


    }

    public static void verticalTraversal(BinaryTreeNode node) {
        Queue<Pair<Integer, BinaryTreeNode>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, node));
        Map<Integer, List<Integer>> distMap = new HashMap<>();

        int minDistance = 0, maxDistance = 0;
        while(!queue.isEmpty()) {
            Pair<Integer, BinaryTreeNode> currPair = queue.poll();
            if(currPair.node.left != null) {
                queue.add(new Pair<>(currPair.distance - 1, currPair.node.left));
            }
            if(currPair.node.right != null) {
                queue.add(new Pair<>(currPair.distance + 1, currPair.node.right));
            }

            distMap.putIfAbsent(currPair.distance, new ArrayList<>());
            distMap.get(currPair.distance).add(currPair.node.data);

            minDistance = Math.min(minDistance, currPair.distance);
            maxDistance = Math.max(maxDistance, currPair.distance);
        }

        for (int i = minDistance; i < maxDistance; i++) {
            System.out.println(distMap.get(i).toString());
        }
    }

    static class Pair<K, V> {
        K distance;
        V node;

        public Pair(K distance, V node) {
            this.distance = distance;
            this.node = node;
        }
    }

}
