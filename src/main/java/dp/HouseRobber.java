package dp;

import java.util.Arrays;

public class HouseRobber {

    // TLE
    public int recursion(int[] nums) {
        return recur(nums, 0);
    }

    private int recur(int[] house, int i) {
        if (i >= house.length) {
            return 0;
        }
        return Math.max(house[i] + recur(house, i + 2), recur(house, i + 1));
    }

    int[] memorization;
    final int UNREACHABLE_NUMBER  = -1;

    public int topDown(int[] nums) {
        memorization = new int[nums.length];
        Arrays.fill(memorization, UNREACHABLE_NUMBER);
        // need to init with unreachable number
        return topDownRecur(nums, 0);
    }

    public int topDownRecur(int[] house, int i) {
        if (i >= house.length) {
            return 0;
        }
        if (memorization[i] != UNREACHABLE_NUMBER) {
            return memorization[i];
        }
        memorization[i] = Math.max(house[i] + topDownRecur(house, i + 2), topDownRecur(house, i + 1));
        return memorization[i];
    }

    public int bottomUp(int[] nums) {
        final int n = nums.length;
        // why n + 2? because we need some spaces for + 2
        int[] dp = new int[n + 2];
        // base case starts from num.length - 1 to 0
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(nums[i] + dp[i + 2], dp[i + 1]);
        }
        return dp[0];
    }

    public int optimize(int[] nums) {
        final int n = nums.length;
        int nextHouse = 0;
        int nextNextHouse = 0;
        int currentHouse = 0;
        for (int i = n - 1; i >= 0; i--) {
            currentHouse = Math.max(nums[i] + nextNextHouse, nextHouse);
            nextNextHouse = nextHouse;
            nextHouse = currentHouse;
        }
        return currentHouse;
    }

}
