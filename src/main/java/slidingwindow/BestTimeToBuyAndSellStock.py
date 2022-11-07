from typing import List
import sys


class Solution:

    def maxProfit(self, prices: List[int]) -> int:
        buy_price = sys.maxsize
        max_profit = 0
        for price in prices:
            if price < buy_price:
                buy_price = prices
            max_profit = max(max_profit, price - buy_price)
        return max_profit

    def maxProfit2(self, prices: List[int]) -> int:
        if len(prices) == 1 or (len(prices) == 2 and prices[0] >= prices[1]):
            return 0

        buy_day = 0
        # buy_price = prices[buy_day]
        sell_day = buy_day + 1
        max_profit = 0
        while buy_day < len(prices) - 1:
            sell_price = prices[sell_day]
            buy_price = prices[buy_day]
            if sell_price < buy_price:
                buy_day = sell_day
            else:
                max_profit = max(max_profit, prices[sell_day] - prices[buy_day])
                sell_day += 1

            # while sell_day < len(prices) and prices[sell_day] - prices[buy_day] < 0:
            #     sell_day += 1
            # if sell_day >= len(prices):
            #     buy_day += 1
            #     sell_day = buy_day + 1
            # else:
            #     # print(sell_day, buy_day)
            #     max_profit = max(max_profit, prices[sell_day] - prices[buy_day])
            #     sell_day += 1

        return max_profit


if __name__ == '__main__':
    s = Solution()
    # print(s.maxProfit([7, 1, 5, 3, 6, 4]))
    # print(s.maxProfit([7, 6, 4, 3, 1]))
    print(s.maxProfit([2, 1, 4]))
