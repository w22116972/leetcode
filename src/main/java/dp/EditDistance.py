class Solution:
    def bottom_up(self, word1: str, word2: str) -> int:
        row_size = len(word1)
        col_size = len(word2)
        dp = [[None] * (col_size + 1)] * (row_size + 1)  # key=(row,col)
        # base case
        for row in range(row_size):
            # row_size - row
            dp[row][col_size] = row + 1  # since index starts with 0 so plus one
        for col in range(col_size):
            # col_size - col
            dp[row_size][col] = col + 1

        for row in range(row_size - 1, -1, -1):
            for col in range(col_size - 1, -1, -1):
                if word1[row] == word2[col]:
                    dp[row][col] = dp[row + 1][col + 1]
                else:  # 3 choices here, will increase operation number by 1
                    distance_if_delete = dp[row + 1][col]
                    distance_if_insert = dp[row][col + 1]
                    distance_if_replace = dp[row + 1][col + 1]
                    dp[row][col] = 1 + min(distance_if_delete, distance_if_insert, distance_if_replace)
        return dp[0][0]

    def bottom_up(self, word1: str, word2: str) -> int:
        dp = [[0] * (len(word2) + 1)] * (len(word1) + 1)

        # base case
        for i in range(1, len(word1) + 1):
            dp[i][0] = i
        for j in range(1, len(word2) + 1):
            dp[0][j] = j

        for i in range(1, len(word1) + 1):
            for j in range(1, len(word2) + 1):
                # offset is -1
                if word1[i - 1] == word2[j - 1]:
                    dp[i][j] = dp[i - 1][j - 1]
                else:
                    dp[i][j] = min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1,
                        dp[i - 1][j - 1] + 1
                    )
        return dp[len(word1)][len(word2)]

    def minDistance(self, word1: str, word2: str) -> int:
        pass
        # dp is 2-dim array with 0s -> [word1][word2]
        # dp = [[0] * len(word2)] * len(word1)
        # # base case
        # for row in range(len(word1))
        #
        # if word1 == '' and word2 == '':
        #     return 0
        # elif word1 == '' and len(word2) > 0:
        #     return len(word2)
        # elif len(word1) > 0 and word2 == '':
        #     return len(word1)
        # else:
            # i in word1, j in word2
            # i = 0
            # j = 0