package stack;

import java.util.LinkedList;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        final LinkedList<Integer> head = new LinkedList<>();
        final LinkedList<Integer> tail = new LinkedList<>();

        while (x > 0) {
            int i = x % 10;
            head.add(i);
            tail.add(i);
            x /= 10;
        }
        int i = 0;
        while (i < head.size()) {
            if (head.pollFirst() != tail.pollLast()) {
                return false;
            }
        }
        return true;
    }
}
