package slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean sol(String s1, String s2) {
        HashMap<Character, Integer> actual = new HashMap<>();
        HashMap<Character, Integer> expect = new HashMap<>();
        for (char c: s1.toCharArray()) {
            if (expect.containsKey(c)) {
                expect.put(c, expect.get(c) + 1);
            } else {
                actual.put(c, 0);
                expect.put(c, 1);
            }
        }
        int left = 0;
        int right = 0;
        // start sliding s2
        while (right < s2.length()) {
            // sliding right
            // update window (actual)
            char c = s2.charAt(right);
            if (actual.containsKey(c)) {
                actual.put(c, actual.get(c) + 1);
            }

            // condition that stop sliding right

            while (isWindowValid(actual, expect)) {
                if (right - left + 1 == s1.length()) {
                    return true;
                } else {
                    // start to slide left
                    // remove most left char
                    char leftChar = s2.charAt(left);
                    if (actual.containsKey(leftChar)) {
                        actual.put(leftChar, actual.get(leftChar) - 1);
                    }
                    left++;
                }
                // update result
            }
            right++;

        }
        return false;
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
        final PermutationInString permutationInString = new PermutationInString();
        System.out.println("sol(\"ab\", \"eidbaooo\") = " + permutationInString.sol("ab", "eidbaooo"));
        System.out.println("sol(\"ab\", \"eidboaoo\") = " + permutationInString.sol("ab", "eidboaoo"));
    }
}
