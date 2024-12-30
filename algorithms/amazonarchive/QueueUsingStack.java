package algorithms.amazonarchive;

import java.util.Stack;

public class QueueUsingStack {
    public static void main(String args[])
    {
        /* Create a queue with items 1 2 3*/
        MyQueue q = new MyQueue();

        q.enQueue(1);
        q.enQueue(2);
        q.enQueue(3);

        /* Dequeue items */
        System.out.print(q.deQueue() + " ");
        System.out.print(q.deQueue() + " ");
        System.out.println(q.deQueue() + " ");
    }

    public static class MyQueue {
        Stack<Integer> s1, s2;

        public MyQueue() {
            s1 =  new Stack<>();
            s2 = new Stack<>();
        }

        public void enQueue(int x) {
            s1.push(x);
        }

        public int deQueue() {
            int n = s1.size() - 1;
            for (int i = 0; i < n; i++) {
                s2.push(s1.pop());
            }
            int ans = s1.pop();
            for (int i = 0; i < n; i++) {
                s1.push(s2.pop());
            }
            return ans;
        }
    }
}
