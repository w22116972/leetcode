package solution;

import java.util.HashMap;
import java.util.Map;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        final int windowSize = s1.length();
        Map<Character, Integer> substring = new HashMap<>();
        for (char c: s1.toCharArray()) {
            if (substring.containsKey(c)) {
                substring.put(c, substring.get(c) + 1);
            } else {
                substring.put(c, 1);
            }
        }
        Map<Character, Integer> remaining = substring;
        int start = 0;
        int end = 0;
        while (end < s2.length()) {
            while (end - start + 1 != s1.length()) {

            }
        }
        return false;
    }
}
