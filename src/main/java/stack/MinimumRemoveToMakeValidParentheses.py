class Solution:
    def minRemoveToMakeValid(self, s: str) -> str:
        result = list(s)
        stack = []  # Store index of invalid bracket '('

        for i in range(len(result)):
            if result[i] == '(':
                stack.append(i)
            elif result[i] == ')' and len(stack) > 0:
                stack.pop()
            elif result[i] == ')':  # if stack doesn't have bracket '(' then this ')' must be invalid
                result[i] = ''

        # Replace invalid bracket with empty string
        while len(stack) > 0:
            result[stack.pop()] = ''

        return ''.join(result)


if __name__ == '__main__':
    s = Solution()
    print(s.minRemoveToMakeValid("lee(t(c)o)de)"))
    # print(s.minRemoveToMakeValid("a)b(c)d"))
    # print(s.minRemoveToMakeValid("))(("))
