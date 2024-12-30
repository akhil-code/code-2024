package algorithms.amazonarchive;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.add(1);
        s.add(2);
        s.add(3);

        System.out.println("current size: " + s.size());
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        s.remove();
        System.out.println(s.top());
        System.out.println("current size: " + s.size());
    }

    public static class MyStack {
        private Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void add(int i) {
            int n = q.size();
            q.add(i);
            for (int j = 0; j < n; j++) {
                q.add(q.poll());
            }
        }

        public int remove() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public int size() {
            return q.size();
        }
    }
}
