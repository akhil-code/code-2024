package datastructures.btrees;

import datastructures.btrees.BTreeUtil;
import datastructures.btrees.model.BinaryTreeNode;
import datastructures.btrees.traversals.bfs.LevelOrderTraversal;

import java.util.LinkedList;
import java.util.Queue;

public class Deletion {
    public static void main(String[] args) {
        BinaryTreeNode tree = BTreeUtil.createDummyTree();
        deleteNode(tree, 2);
        LevelOrderTraversal.levelOrderTraversal(tree);
    }

    public static void deleteNode(BinaryTreeNode tree, int data) {
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        Queue<BinaryTreeNode> parentQueue = new LinkedList<>();
        queue.add(tree);

        while(!queue.isEmpty()) {
            BinaryTreeNode currNode = queue.remove();
            BinaryTreeNode parentNode = null;
            if(!parentQueue.isEmpty()) {
                parentNode = parentQueue.remove();
            }

            if(currNode.data == data) {
                break;
            }
            if(currNode.left != null) {
                queue.add(currNode.left);
                parentQueue.add(currNode);
            }
            if(currNode.right != null) {
                queue.add(currNode.right);
                parentQueue.add(currNode);
            }
        }



    }
}
