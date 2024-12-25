package solution;

import java.util.*;

public class RepeatedDNASequences {
    /**
     * Iterate through the string and keep track of the 10 character window of DNA, if the window is already seen, add it to the result.
     * Assume n is the length of the input string s and k is the length of the DNA sequence.
     * Each iteration we have substring that s[i] to s[i + k - 1]
     * T(n) = O(n) to iterate through the `s`
     * S(n) = O(n) to store the result
     */
    public List<String> findRepeatedDnaSequences(String s) {
        if (s.length() < 10) {
            return List.of();
        }

        Set<String> result = new HashSet<>();
        Set<String> seenDna = new HashSet<>();
        StringBuilder dnaWindow = new StringBuilder();

        for (int i = 0; i < 10; i++) {
            dnaWindow.append(s.charAt(i));
        }

        int rightIndex = 9;
        while (rightIndex < s.length()) {
            String currentDna = dnaWindow.toString();
            if (seenDna.contains(currentDna)) {
                result.add(currentDna);
            } else {
                seenDna.add(currentDna);
            }

            if (rightIndex == s.length() - 1) {
                break;
            } else {
                rightIndex++;
                dnaWindow.deleteCharAt(0);
                dnaWindow.append(s.charAt(rightIndex));
            }
        }
        return result.stream().toList();
    }

    public static void main(String[] args) {
        RepeatedDNASequences sol = new RepeatedDNASequences();
        List<String> result = sol.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT");
        System.out.println(result);
    }

}
