package leetcode;

// In-place -> swap, use two pointers
// Time Complexity = O(n), where n is the length of the string
// Space Complexity = O(1), because we are using only a few extra variables
public class LC_344_ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            // swap
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }
}
