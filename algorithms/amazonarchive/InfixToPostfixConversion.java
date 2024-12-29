package algorithms.amazonarchive;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfixConversion {
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i";
        final String postFix = infixToPostfix(exp);
        System.out.println(postFix);
    }

    private static String infixToPostfix(String exp) {
        StringBuilder postfixBuilder = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        int n = exp.length();
        for (int i = 0; i < n; i++) {
            char c = exp.charAt(i);
            if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9')) {
              postfixBuilder.append(c);
            } else if(c == '(') {
                stack.push(c);
            } else if(c == ')') {
                System.out.println("true");
                while(stack.peek() != '(')
                    postfixBuilder.append(stack.pop());
                stack.pop();
            } else {
                while(!stack.isEmpty() && precedence(c) <= precedence(stack.peek())) {
                    postfixBuilder.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while(!stack.isEmpty()) {
            postfixBuilder.append(stack.pop());
        }
        return postfixBuilder.toString();
    }

    private static int precedence(char c) {
        if(c == '+' || c == '-') {
            return 0;
        } else if(c == '*' || c == '/') {
            return 1;
        } else if(c == '^') {
            return 2;
        }
        return -1;
    }
}
