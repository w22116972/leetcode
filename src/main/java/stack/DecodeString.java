package stack;

import java.util.HashSet;
import java.util.LinkedList;

public class DecodeString {
    public String decodeString(String s) {
        final LinkedList<Character> stack = new LinkedList<>();
        for (char c: s.toCharArray()) {
            if (c != ']') {
                stack.add(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while (stack.getLast() != '[') {
                    sb.append(stack.removeLast());
                }
                sb.reverse();
                // remove '['
                stack.removeLast();
                int base = 1;
                int num = 0;
                while (!stack.isEmpty() && Character.isDigit(stack.getLast())) {
                    num += (stack.pollLast() - '0') * base;
                    base *= 10;
                }
                for (int i = 1; i <= num; i++) {
                    for (char j: sb.toString().toCharArray()) {
                        stack.addLast(j);
                    }
                }
            }
        }
        char[] result = new char[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.pollFirst();
        }
        return new String(result);
    }
}
