import java.util.Stack;

public class RemoveAllAdjacentDuplicatesInStringII {
    public String removeDuplicates(String s, int k) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                int count = countStack.pop();
                if (count == k - 1) {
                    stack.pop();
                } else {
                    countStack.push(count + 1);
                }
            } else {
                stack.push(c);
                countStack.push(1);
            }
        }
        // convert stack to string
        StringBuilder sb = new StringBuilder(); // use string builder to avoid string concatenation
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}
