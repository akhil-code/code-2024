package datastructures.btrees;

public class VerticalSumBinaryTree {

    public static void main(String[] args) {
        // Let us construct the tree shown above
        TNode root = new TNode(1);
        root.left = new TNode(2);
        root.right = new TNode(3);
        root.left.left = new TNode(4);
        root.left.right = new TNode(5);
        root.right.left = new TNode(6);
        root.right.right = new TNode(7);

        LNode rootNode = verticalSum(root, 0, null);
        while(rootNode.left != null) {
            rootNode = rootNode.left;
        }
        while(rootNode != null) {
            System.out.println(rootNode.hd + " : " + rootNode.sum);
            rootNode = rootNode.right;
        }
    }

    public static LNode verticalSum(TNode root, int hd, LNode currNode) {
        if(root == null) {
            return currNode;
        }

        // create linked list and pass it
        if(currNode == null) {
            currNode = new LNode(hd, 0);
        }

        currNode.hd = hd;
        currNode.sum += root.data;

        // create double links
        if(root.left != null) {
            if(currNode.left == null) {
                currNode.left = new LNode(hd - 1, 0);
                currNode.left.right = currNode;
            }
            verticalSum(root.left, hd - 1, currNode.left);
        }

        if(root.right != null) {
            if(currNode.right == null) {
                currNode.right = new LNode(hd + 1 , 0);
                currNode.right.left = currNode;
            }
            verticalSum(root.right, hd + 1, currNode.right);
        }

        return currNode;
    }

    static class LNode {
        int hd;
        int sum;
        LNode left = null;
        LNode right = null;

        public LNode(int hd, int sum) {
            this.hd = hd;
            this.sum = sum;
        }
    }

    static class TNode {
        int data;
        TNode left;
        TNode right;

        public TNode(int data) {
            this.data = data;
        }
    }



}
