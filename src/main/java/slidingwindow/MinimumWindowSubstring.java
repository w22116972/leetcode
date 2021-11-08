package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String sol(String s, String t) {
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
        System.out.println("sol(\"a\", \"aa\") = " + sol("a", "aa"));
        System.out.println("sol(\"a\", \"a\") = " + sol("a", "a"));
        System.out.println("sol(\"ADOBECODEBANC\", \"ABC\") = " + sol("ADOBECODEBANC", "ABC"));
    }
}
