from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        if len(prices) == 1 or (len(prices) == 2 and prices[0] >= prices[1]):
            return 0

        buy_day = 0
        # buy_price = prices[buy_day]
        sell_day = buy_day + 1
        max_profit = 0
        while buy_day < len(prices) - 1 and sell_day < len(prices):
            while sell_day < len(prices) and prices[sell_day] - prices[buy_day] < 0:
                sell_day += 1
            if sell_day == len(prices):
                buy_day += 1
                sell_day = buy_day + 1
            else:
                max_profit = max(max_profit, prices[sell_day] - prices[buy_day])
                sell_day += 1
        return max_profit


