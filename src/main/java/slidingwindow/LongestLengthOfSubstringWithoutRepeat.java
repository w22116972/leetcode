package slidingwindow;

import java.util.HashMap;

public class LongestLengthOfSubstringWithoutRepeat {
    public Integer sol(String s) {
        int left = 0;
        int right = 0;
        int longestLength = 0;

        final HashMap<Character, Integer> actual = new HashMap<>();

        while (right < s.length()) {
            char rightChar = s.charAt(right);
            if (actual.containsKey(rightChar)) {
                actual.put(rightChar, actual.get(rightChar) + 1);
            } else {
                actual.put(rightChar, 1);
            }
            while (actual.get(rightChar) > 1) {
                char leftChar = s.charAt(left);
                actual.put(leftChar, actual.get(leftChar) - 1);
                left++;
            }
            longestLength = Math.max(longestLength, right - left + 1);
            right++;
        }
        return longestLength;
    }

    public static void main(String[] args) {
        final LongestLengthOfSubstringWithoutRepeat longestLengthOfSubstringWithoutRepeat = new LongestLengthOfSubstringWithoutRepeat();
        System.out.println("sol(\"abcabcbb\") = " + longestLengthOfSubstringWithoutRepeat.sol("abcabcbb"));
        System.out.println("sol(\"bbbbb\") = " + longestLengthOfSubstringWithoutRepeat.sol("bbbbb"));
        System.out.println("sol(\"pwwkew\") = " + longestLengthOfSubstringWithoutRepeat.sol("pwwkew"));
        System.out.println("sol(\"\") = " + longestLengthOfSubstringWithoutRepeat.sol(""));
    }
}
