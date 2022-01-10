package dp;

import java.util.Arrays;

public class JumperGameII {
    int[] memo;

    // TLE
    public int topDown(int[] nums) {
        final int n = nums.length;
        memo = new int[n];
        Arrays.fill(memo, n);

        return recur(nums, 0);
    }

    public int recur(int[] nums, int i) {
        final int n = nums.length;
        final int defaultValue = n;
        // base case
        // if reach end, then there is no need for any steps
        if (i >= n - 1) {
            return 0;
        }
        // use memo
        if (memo[i] != defaultValue) {
            return memo[i];
        }

        int steps = nums[i];
        for (int step = 1; step <= steps; step++) {
            int localOptimalResult = recur(nums, i + step);
            memo[i] = Math.min(memo[i], localOptimalResult + 1);
        }
        return memo[i];
    }

    //
    public int greedy(int[] nums) {
        final int n = nums.length;
        int jumpCount = 0;
        int currentEnd = 0;
        int farthestIndex = -1;
        for (int index = 0; index < n - 1; index++) {
            final int currentStep = nums[index];
            farthestIndex = Math.max(farthestIndex, index + currentStep);
            if (index == currentEnd) {
                jumpCount++;
                currentEnd = farthestIndex;
            }
        }
        return jumpCount;
    }
}
