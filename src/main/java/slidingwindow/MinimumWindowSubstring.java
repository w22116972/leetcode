package slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> expected = new HashMap<>();
        for (char c: t.toCharArray()) {
            expected.put(c, expected.getOrDefault(c, 0) + 1);
        }

        HashMap<Character, Integer> currentWindow = new HashMap<>();
        int tailIndex = 0;
        int headIndex = 0;
        // when char and its count in window is matched, then numOfMatched++, vice versa
        // maximum numOfMatched is size of `expected`
        int actualMatchNumber = 0;
        int expectedMatchNumber = expected.size();
        int minWindowLength = Integer.MAX_VALUE;
        int resultHeadIndex = 0;
        int resultTailIndex = 0;

        while (tailIndex < s.length()) {
            // expand window
            char tail = s.charAt(tailIndex);
            currentWindow.put(tail, currentWindow.getOrDefault(tail, 0) + 1);
            if (expected.containsKey(tail) && Objects.equals(currentWindow.get(tail), expected.get(tail))) {
                actualMatchNumber++;
            }
            // shrink window
            while (headIndex <= tailIndex && expectedMatchNumber == actualMatchNumber) {
                char head = s.charAt(headIndex);
                final int currentWindowLength = tailIndex - headIndex + 1;
                if (currentWindowLength < minWindowLength) {
                    minWindowLength = currentWindowLength;
                    resultHeadIndex = headIndex;
                    resultTailIndex = tailIndex;
                }
                currentWindow.put(head, currentWindow.get(head) - 1);
                if (expected.containsKey(head) && currentWindow.get(head) == expected.get(head) - 1) {
                    actualMatchNumber--;
                }
                headIndex++;
            }
            tailIndex++;
        }
        return minWindowLength == Integer.MAX_VALUE ? "":s.substring(resultHeadIndex, resultTailIndex + 1);
    }

    public static String bruteForce(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }

        // use HashMap to store T
        final HashMap<Character, Integer> expect = new HashMap<>();
        final HashMap<Character, Integer> actual = new HashMap<>();
        for (char c: t.toCharArray()) {
            if (expect.containsKey(c)) {
                expect.put(c, expect.get(c) + 1);
            } else {
                actual.put(c, 0);
                expect.put(c, 1);
            }
        }
//        HashMap<Character, Integer> actual = expect;

        // init window
        int left = 0;
        int right = 0;
        int minLength = Integer.MAX_VALUE;
        int resultLeft = 0;

        while (right < s.length()) {
            // slide right
            final char rightChar = s.charAt(right);
            if (expect.containsKey(rightChar)) {
                actual.put(rightChar, actual.get(rightChar) + 1);
            }
            // stop sliding right and start slide left
            while (isWindowValid(actual, expect)) {
                // check result
                if (right - left + 1 < minLength) {
                    resultLeft = left;
                    minLength = Math.min(minLength, right - left + 1);
                }

                // slide left
                final char leftChar = s.charAt(left);
                // remove left char from actual
                if (actual.containsKey(leftChar)) {
                    actual.put(leftChar, actual.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(resultLeft, resultLeft + minLength);
    }

    private static boolean isWindowValid(HashMap<Character, Integer> actual, HashMap<Character, Integer> expect) {
        for (Map.Entry<Character, Integer> actualEntry : actual.entrySet()) {
            if (actualEntry.getValue() < expect.get(actualEntry.getKey()) ) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final MinimumWindowSubstring sol = new MinimumWindowSubstring();
        System.out.println("sol(\"a\", \"aa\") = " + sol.minWindow("a", "aa"));
        System.out.println("sol(\"a\", \"a\") = " + sol.minWindow("a", "a"));
        // ADOBECODEBANC
        System.out.println("sol(\"ADOBECODEBANC\", \"ABC\") = " + sol.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println("sol(\"b\", \"a\") = " + sol.minWindow("b", "a")); // return ""
    }
}
