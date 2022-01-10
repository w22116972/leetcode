package dp;

import java.util.Arrays;

public class LongestPalindromeSubsequence {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        System.out.println("s.length() = " + s.length());
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.println("i = " + i);
//            System.out.println(Arrays.deepToString(dp));
            for (int j = i+1; j < s.length(); j++) {
                System.out.println("j = " + j);
//                System.out.println(i);
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        return dp[0][s.length()-1];
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindromeSubsequence().longestPalindromeSubseq("cbbd"));
    }
}
