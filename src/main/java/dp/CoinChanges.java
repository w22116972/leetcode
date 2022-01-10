package dp;

public class CoinChanges {
    int coinChange(int[] coins, int amount) {
        return getMinCoinNumber(coins, amount);
    }
    int getMinCoinNumber(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        } else if (amount < 0) {
            return -1;
        }
        int minCoinNumber = Integer.MAX_VALUE;
        for (int coinValue: coins) {
            int minCoinNumberIfChooseThisCoin = getMinCoinNumber(coins, amount - coinValue);
            if (minCoinNumberIfChooseThisCoin == -1) {
                continue; // try next coin
            }
            minCoinNumber = Math.min(minCoinNumber, minCoinNumberIfChooseThisCoin + 1);
        }
        return minCoinNumber;
    }

    int bottomUp(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        return 0;
    }

}
