package slidingwindow;

public class BestTimeToBuyAndSellStock {
    public int sol(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int buyDay = 0;
        int sellDay = buyDay + 1;

        int maxProfit = 0;
        while (buyDay < prices.length - 1 && sellDay < prices.length) {
            final int sellPrice = prices[sellDay];
            final int buyPrice = prices[buyDay];
            if (sellPrice < buyPrice) {
                buyDay = sellDay;
            } else {
                maxProfit = Math.max(maxProfit, sellPrice - buyPrice);
                sellDay++;
            }
        }
        return maxProfit;
    }
}
