package algorithms.amazonarchive;

import java.util.Stack;

public class StackWithGetMin {
    public static void main(String[] args)
    {
        MyStack s = new MyStack();
        s.push(3);
        s.push(5);
        System.out.println(s.getMin());
        s.push(2);
        s.push(1);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.peek());
    }

    public static class MyStack {
        private Stack<Integer> s;
        private Integer globalMin;

        public MyStack() {
            s = new Stack<>();
        }

        public void push(int x) {
            if(getMin() == null) {
                s.push(x);
                setMin(x);
                return;
            }

            if(x > getMin()) {
                s.push(x);
            } else {
                s.push(2 * x - getMin());
                setMin(x);
            }
        }

        private void setMin(int x) {
            this.globalMin = x;
        }

        public Integer getMin() {
            return globalMin;
        }

        public int peek() {
            if(s.peek() > getMin()) {
                return s.peek();
            } else {
                return getMin();
            }
        }

        public int pop() {
            if(s.peek() > getMin()) {
                return s.pop();
            } else {
                int minElement = getMin();
                setMin(2 * minElement - s.pop());
                return minElement;
            }
        }
    }
}
