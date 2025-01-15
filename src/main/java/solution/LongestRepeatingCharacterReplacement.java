package solution;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] frequencyCount = new int[26]; // only uppercase letter
        int mostFrequentCount = 0;
        int maxSubstringLength = 0;

        int windowLeftIndex = 0;
        int windowRightIndex = 0;
        while (windowRightIndex < s.length()) {
            frequencyCount[s.charAt(windowRightIndex) - 'A']++;
            mostFrequentCount = Math.max(mostFrequentCount, frequencyCount[s.charAt(windowRightIndex) - 'A']);

            while (windowRightIndex - windowLeftIndex + 1 - mostFrequentCount > k) {
                frequencyCount[s.charAt(windowLeftIndex) - 'A']--;
                windowLeftIndex++;
            }

            maxSubstringLength = Math.max(maxSubstringLength, windowRightIndex - windowLeftIndex + 1);

            windowRightIndex++;
        }
        return maxSubstringLength;
    }
}
