package dp;

public class DecodeWays {
    public int recursion(String s) {
        if (s.length() == 0) {
            return 0;
        } else {
            return recur(0, s);
        }
    }

    // number of ways to decode at position i
    private int recur(int index, String s) {
        final int n = s.length();
        // base case: when decoding is finished -> only 1 way
        if (index == n) {
            return 1;
        }
        // only 1~26, there is no 0, so if current char is '0' then it must be no way
        if (s.charAt(index) == '0') {
            return 0;
        }
        int waysOfDecodingAtCurrentIndex = 0;
        int waysOfDecodingAlone = recur(index + 1, s);
        waysOfDecodingAtCurrentIndex += waysOfDecodingAlone;
        if (isNotReachLastIndex(index, n) && isCharValid(index, s)) {
            int waysOfDecodingPairWithNextChar = recur(index + 2, s);
            waysOfDecodingAtCurrentIndex += waysOfDecodingPairWithNextChar;
        }
        return waysOfDecodingAtCurrentIndex;
    }

    private boolean isNotReachLastIndex(int i, int n) {
        return i < n - 1;
    }

    // valid whether char is in 1~26
    private boolean isCharValid(int i, String s) {
        // starts with 1 or less than 27
        return (s.charAt(i) == '1') || (s.charAt(i) == '2' && s.charAt(i + 1) < '7');
    }

    int[] memo;
    public int topDown(String s) {
        final int n = s.length();
        memo = new int[n];
        if (n == 0) {
            return 0;
        } else {
            return topDownRecur(0, s);
        }
    }

    public int topDownRecur(int i, String s) {
        final int n = s.length();
        if (i == n) {
            return 1;
        }
        if (s.charAt(i) == '0') {
            return 0;
        }
        if (memo[i] != 0) {
            return memo[i];
        }
        int waysOfDecodingAtCurrentIndex = 0;
        int waysOfDecodingAlone = topDownRecur(i + 1, s);
        waysOfDecodingAtCurrentIndex += waysOfDecodingAlone;
        if (isNotReachLastIndex(i, n) && isCharValid(i, s)) {
            int waysOfDecodingPairWithNextChar = topDownRecur(i + 2, s);
            waysOfDecodingAtCurrentIndex += waysOfDecodingPairWithNextChar;
        }
        memo[i] = waysOfDecodingAtCurrentIndex;
        return waysOfDecodingAtCurrentIndex;
    }

    public int bottomUp(String s) {
        final int n = s.length();
        int[] dp = new int[n + 1];
        // base case: last index hsa only 1 way
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) != '0') {
                int waysAtCurrentIndex = 0;
                waysAtCurrentIndex += dp[i+1];
                if (isNotReachLastIndex(i, n) && isCharValid(i, s)) {
                    waysAtCurrentIndex += dp[i+2];
                }
                dp[i] = waysAtCurrentIndex;
            }
        }
        return dp[0];
    }

    public int optimize(String s) {
        int dp1=1;
        int dp2=0;
        final int n=s.length();
        for(int i=n-1;i>=0;i--) {
            int dp=s.charAt(i)=='0'?0:dp1;
            if(isNotReachLastIndex(i, n) && isCharValid(i, s)) {
                dp+=dp2;
            }
            dp2=dp1;
            dp1=dp;
        }
        return dp1;
    }

    // can't explain base case
//    public int bottomUp2(String s) {
//        // if s has leading 0
//        if (s.charAt(0) == '0') {
//            return 0;
//        }
//        final int n = s.length();
//        int[] dp = new int[n + 1];
//        dp[0] = 0;
//        dp[1] = 1;
//        for (int i = 2; i <= n; i++) {
//            int num = Integer.parseInt(s.substring(i - 2, i));
//            if(num <= 26 && num >= 10) {
//                dp[i] += dp[i - 2];
//            }
//            if(s.charAt(i - 1) != '0')
//                dp[i] += dp[i - 1];
//        }
//        return dp[n];
//    }
}
