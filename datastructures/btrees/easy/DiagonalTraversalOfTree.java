package datastructures.btrees.easy;

import datastructures.btrees.model.BinaryTreeNode;

import java.util.*;

public class DiagonalTraversalOfTree {
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(6);
        root.right.right = new BinaryTreeNode(14);
        root.right.right.left = new BinaryTreeNode(13);
        root.left.right.left = new BinaryTreeNode(4);
        root.left.right.right = new BinaryTreeNode(7);

        diagonalTraversal(root);
        System.out.println("");
        diagonalTraversalAtDifferentLevels(root);
    }

    public static void diagonalTraversal(BinaryTreeNode tree) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        BinaryTreeNode currNode = tree;
        queue.add(currNode);

        while(!queue.isEmpty()) {
            currNode = queue.remove();
            while(currNode != null) {
                if(currNode.left != null) {
                    queue.add(currNode.left);
                }
                System.out.print(currNode.data + " -> ");
                currNode = currNode.right;
            }
        }
    }

    public static void diagonalTraversalAtDifferentLevels(BinaryTreeNode tree) {
        Queue<Dnode> queue = new LinkedList<>();
        Dnode currNode = new Dnode(tree, 0);
        queue.add(currNode);
        Map<Integer, List<Integer>> map = new HashMap<>();

        while(!queue.isEmpty()) {
            currNode = queue.remove();
            while(currNode.node != null) {
                if(currNode.node.left != null) {
                    queue.add(new Dnode(currNode.node.left, currNode.level - 1));
                }
                if (!map.containsKey(currNode.level)) {
                    List<Integer> newList = new ArrayList<>();
                    newList.add(currNode.node.data);
                    map.put(currNode.level, newList);
                } else {
                    map.get(currNode.level).add(currNode.node.data);
                }
                currNode = new Dnode(currNode.node.right, currNode.level);
            }
        }


        map.forEach((s, elements) ->  {
            System.out.println(elements.toString());
        });
    }


    // Diagonal node to store the levels
    static class Dnode {
        BinaryTreeNode node;
        int level;

        public Dnode(BinaryTreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
}
