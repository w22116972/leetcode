package dp;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        String longestString = "";
        for (int i = 0; i < s.length(); i++) {
            String oddPalindrome = findPalindrome(s, i, i);
            String evenPalindrome = findPalindrome(s, i, i + 1);
            longestString = getLongestString(longestString, oddPalindrome, evenPalindrome);
        }
        return longestString;
    }

    private String getLongestString(String s1, String s2, String s3) {
        if (s1.length() >= s2.length() && s1.length() >= s3.length()) {
            return s1;
        } else if (s2.length() >= s1.length() && s2.length() >= s3.length()) {
            return s2;
        } else {
            return s3;
        }
    }

    private String findPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 此時的left,跟right已經超出一點，所以要退回1 (offset)
        return s.substring(left + 1, right);
    }
}
