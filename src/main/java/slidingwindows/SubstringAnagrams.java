package slidingwindows;

public class SubstringAnagrams {
    public int substringAnagrams(String s, String t) {
        int lenS = s.length();
        int lenT = t.length();
        if (lenS < lenT) {
            return 0;
        }
        int count = 0;
        // Note: All elements are automatically initialized to 0 by Java’s design
        int[] expectedFreqs = new int[26];
        int[] windowFreqs = new int[26];
        // Populate 'expectedFreqs' with the characters in string 't'.
        // Note: The expression char c - 'a' calculates the difference between the ASCII values of c and 'a',
        //  effectively mapping 'a' to index 0, 'b' to 1, 'c' to 2, and so on up to 'z' at 25.
        //  This allows each lowercase letter to be represented as a unique index from 0 to 25 in an array
        for (char c: t.toCharArray()) {
            expectedFreqs[c - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < lenS) {
            // Add the character at the right pointer to 'windowFreqs' before sliding the window.
            windowFreqs[s.charAt(right) - 'a']++;
            // If the window has reached the expected fixed length, we advance the left pointer as well as the right pointer to slide the window.
            if (right - left + 1 == lenT) {
                // If the frequency of the characters in the window matches the frequency of the characters in 'expectedFreqs', we have found an anagram.
                if (isAnagram(windowFreqs, expectedFreqs)) {
                    count++;
                }
                // Remove the character at the left pointer from 'windowFreqs' before advancing the left pointer.
                windowFreqs[s.charAt(left) - 'a']--;
                left++;
            }
            right++;
        }
        return count;
    }

    private boolean isAnagram(int[] windowFreqs, int[] expectedFreqs) {
        for (int i = 0; i < 26; i++) {
            if (windowFreqs[i] != expectedFreqs[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("new SubstringAnagrams().substringAnagrams(\"caabab\", \"aba\") = " + new SubstringAnagrams().substringAnagrams("caabab", "aba"));
    }
}
