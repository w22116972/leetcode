package stack;

import java.util.LinkedList;

public class ValidParentheses {
    public boolean isValid(String s) {
        final LinkedList<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isLeftParentheses(c)) {
                stack.addLast(c);
            } else if (!stack.isEmpty() && isMatchedLeftParentheses(stack, c)) {
                stack.removeLast();
            } else {
                return false;
            }
        }

        return stack.isEmpty();
    }

    private boolean isLeftParentheses(char c) {
        return c == '{' || c == '(' || c == '[';
    }

    private boolean isSameParentheses(char left, char right) {
        return (left == '{' && right == '}') || (left == '[' && right == ']') || (left == '(' && right == ')');
    }

    private boolean isMatchedLeftParentheses(LinkedList<Character> stack, char right) {
        return isSameParentheses(stack.getLast(), right);
    }
}
