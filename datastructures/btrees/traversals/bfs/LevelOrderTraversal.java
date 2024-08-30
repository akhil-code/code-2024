package datastructures.btrees.traversals.bfs;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        levelOrderTraversal(tree);
    }

    public static void levelOrderTraversal(BinaryTreeNode rootNode) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.add(rootNode);

        int count = 1;
        while(!queue.isEmpty()) {
            BinaryTreeNode curr = queue.remove();
            System.out.print(curr.data + " -> ");
            if(curr.left != null) {
                queue.add(curr.left);
            }
            if(curr.right != null) {
                queue.add(curr.right);
            }
            count--;

            if(count == 0) {
                System.out.println("");
                count = queue.size();
            }
        }
    }
}
