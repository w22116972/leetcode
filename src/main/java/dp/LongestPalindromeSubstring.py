class Solution:
    def longestPalindrome(self, s: str) -> str:
        n = len(s)
        max_length = 0
        longest_palindrome = ""
        for i in range(n):
            # odd length
            left = i
            right = i
            while left >= 0 and right < n and s[left] == s[right]:
                if (right - left + 1) > max_length:
                    longest_palindrome = s[left:right + 1]
                    max_length = right - left + 1
                left -= 1
                right += 1

            # even length
            left = i
            right = i + 1
            while left >= 0 and right < n and s[left] == s[right]:
                if (right - left + 1) > max_length:
                    longest_palindrome = s[left:right + 1]
                    max_length = right - left + 1
                left -= 1
                right += 1
        return longest_palindrome
