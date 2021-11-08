package slidingwindow;

import java.util.*;

public class FindAllAnagramsInString {
    public List<Integer> sol(String s, String p) {
        int left = 0;
        int right = 0;
        List<Integer> result = new ArrayList<>();

        // create `expect` from p
        final HashMap<Character, Integer> expect = new HashMap<>();
        final HashMap<Character, Integer> actual = new HashMap<>();
        for (char c: p.toCharArray()) {
            if (expect.containsKey(c)) {
                expect.put(c, expect.get(c) + 1);
            } else {
                expect.put(c, 1);
                actual.put(c, 0);
            }
        }

        // start to slide right
        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (actual.containsKey(rightChar)) {
                actual.put(rightChar, actual.get(rightChar) + 1);
            }
            if (right - left + 1 == p.length()) {
                if (isWindowSameAsExpect(expect, actual)) {
                    result.add(left);
                }
                char leftChar = s.charAt(left);
                if (actual.containsKey(leftChar)) {
                    actual.put(leftChar, actual.get(leftChar) - 1);
                }
                left++;
            }
            right++;
        }
        return result;
    }

    private static boolean isWindowSameAsExpect(HashMap<Character, Integer> expect, HashMap<Character, Integer> actual) {
        for (Map.Entry<Character, Integer> actualEntry : actual.entrySet()) {
            if (actualEntry.getValue().intValue() != expect.get(actualEntry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final FindAllAnagramsInString findAllAnagramsInString = new FindAllAnagramsInString();
        System.out.println("sol(\"cbaebabacd\", \"abc\") = " + findAllAnagramsInString.sol("cbaebabacd", "abc"));
        System.out.println("sol(\"abab\", \"ab\") = " + findAllAnagramsInString.sol("abab", "ab"));
    }
}
