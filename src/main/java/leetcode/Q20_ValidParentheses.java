package leetcode;

import java.util.LinkedList;

public class Q20_ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }
        LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty()) {
                stack.addLast(c);
            } else {
                char top = stack.getLast();
                if (top == '{' && c == '}') {
                    stack.removeLast();
                } else if (top == '[' && c == ']') {
                    stack.removeLast();
                } else if (top == '(' && c == ')') {
                    stack.removeLast();
                } else {
                    stack.addLast(c);
                }
            }
        }
        return stack.isEmpty();
    }
}
