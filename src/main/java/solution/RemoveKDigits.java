package solution;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> stack = new Stack<>();
        for (char digit: num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            if (stack.size() == 1 && stack.peek() == '0') {
                stack.pop();
            }
            stack.push(digit);
        }
        // remove the remaining digits from the tail if k != 0
        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k--;
        }
        // convert stack to string
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.isEmpty()? "0":sb.reverse().toString();
    }
}
