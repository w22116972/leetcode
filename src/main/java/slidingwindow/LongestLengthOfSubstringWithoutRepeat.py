class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        left_index = 0
        right_index = 0
        max_length = 0
        char_to_count = {}
        while right_index < len(s):
            current_char = s[right_index]
            if current_char not in char_to_count:
                char_to_count[current_char] = 1
            else:
                char_to_count[current_char] += 1
            # when char_to_count[current_char] > 1
            while char_to_count[current_char] > 1:
                char_to_count[s[left_index]] = char_to_count[s[left_index]] - 1
                left_index += 1
            max_length = max(max_length, right_index - left_index + 1)
            right_index += 1
        return max_length


    def sol2(self, s: str) -> int:
        if len(s) <= 1:
            return len(s)

        seen_char = {}
        left_index = 0
        max_length = 0
        for right_index in range(len(s)):
            current_char = s[right_index]
            prev_seen_char_index = seen_char[current_char] if current_char in seen_char else 0

            if prev_seen_char_index >= left_index:
                left_index = prev_seen_char_index + 1

            seen_char[current_char] = right_index
            max_length = max(max_length, right_index - left_index + 1)
        return max_length
