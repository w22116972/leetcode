package slidingwindow;

import java.util.HashMap;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int maxFreq = 0;

        HashMap<Character, Integer> frequency = new HashMap<>();

        int start = 0;
//        int end = 0;

        int maxLength = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (!frequency.containsKey(c)) {
                frequency.put(c, 1);
            } else {
                frequency.put(c, 1 + frequency.get(c));
            }
            maxFreq = Math.max(maxFreq, frequency.get(c));

            while ((end - start + 1) - maxFreq > k) {
                frequency.put(s.charAt(start), frequency.get(s.charAt(start)) - 1);
                maxFreq = Math.max(maxFreq, frequency.get(s.charAt(start)));
                start++;
            }
            // k is used up
            maxLength = Math.max(maxLength, end - start + 1);
        }
        return maxLength;
    }
}
