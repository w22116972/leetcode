from typing import List

from enum import Enum


class STATUS(Enum):
    BUY = 'buy'
    SELL = 'sell'


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        # max profit at day i with buy/sell state
        dp = {}  # key = (i, canBuy)

        def dfs(i: int, status: STATUS) -> int:
            # if exceed last day then no profit
            if i >= len(prices):
                return 0
            # if it is already cached
            if (i, status) in dp:
                return dp[(i, status)]
            # if we can buy, then we will have to choice: buy or cooldown
            if status == STATUS.BUY:
                # if buy, then go to next day and switch status to sell
                profit_if_buy = dfs(i + 1, STATUS.SELL) - prices[i]
                # if cooldown, then go to next day with same status
                profit_if_cooldown = dfs(i + 1, STATUS.BUY)
                # cache profit at day i and current status
                dp[(i, status)] = max(profit_if_buy, profit_if_cooldown)
            else:  # if can sell, we will have to choice: sell or cooldown
                # if sell, since there will be cool down, so go to next next day
                profit_if_sell = dfs(i + 2, STATUS.BUY) + prices[i]
                # if cooldown, then go to next day with same status
                profit_if_cooldown = dfs(i + 1, STATUS.SELL)
                # cache profit at day i and current status
                dp[(i, status)] = max(profit_if_sell, profit_if_cooldown)
            return dp[(i, status)]

        return dfs(0, STATUS.BUY)


print(Solution().maxProfit([1, 2, 3, 0, 2]))
