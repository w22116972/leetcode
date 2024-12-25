package solution;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @see <a href="https://leetcode.com/problems/implement-strstr/">LeetCode</a>
 *
 *
 */
public class FindTheIndexOfTheFirstOccurrenceInAString {
    public int strStr(String haystack, String needle) {
        for (int left = 0; left <= haystack.length() - needle.length(); left++) {
            int offset = 0;
            while (offset < needle.length() && haystack.charAt(left + offset) == needle.charAt(offset)) {
                offset++;
            }
            if (offset == needle.length()) {
                return left;
            }
        }
        return -1;
    }
}
