package dp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        return dp(s, set, 0);
    }

    private boolean dp(String s, Set<String> set, int startIndex) {
        final int n = s.length();
        // base case: if index goes over s
        if (startIndex == n) {
            return true;
        }
        for (int endIndex = startIndex + 1; endIndex <= n; endIndex++) {
            if (set.contains(s.substring(startIndex, endIndex)) && dp(s, set, endIndex)) {
                return true;
            }
        }
        return false;
    }
    Boolean[] memo;

    public boolean topDown(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        memo = new Boolean[s.length()];
        Arrays.fill(memo, null);
        return topDownRecur(s, set, 0);
    }

    private boolean topDownRecur(String s, Set<String> set, int startIndex) {
        final int n = s.length();
        if (startIndex == n) {
            return true;
        }
        if (memo[startIndex] != null) {
            return memo[startIndex];
        }
        for (int endIndex = startIndex + 1; endIndex <= n; endIndex++) {
            if (set.contains(s.substring(startIndex, endIndex)) && topDownRecur(s, set, endIndex)) {
                memo[startIndex] = true;
                return true;
            }
        }
        memo[startIndex] = false;
        return false;
    }

    public static void main(String[] args) {
        boolean[] x = new boolean[2];

        System.out.println("x[0] = " + x[0]);
    }
}
