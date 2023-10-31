import java.util.Stack;

public class RemoveAllAdjacentDuplicatesString {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
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
