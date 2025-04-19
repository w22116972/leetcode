package hashmapset;

public class LongestChainOfConsecutiveNumbersBruteForce {
    public int longestChainOfConsecutiveNumbersBruteForce(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int longestChain = 0;
        // Look for chains of consecutive numbers that start from each number.
        for (int num : nums) {
            int currentNum = num;
            int currentChain = 1;
            // Continue to find the next consecutive numbers in the chain.
            while (contains(nums, currentNum + 1)) {
                currentNum++;
                currentChain++;
            }
            longestChain = Math.max(longestChain, currentChain);
        }
        return longestChain;

    }

    // Helper method to check if an array contains a specific value
    private boolean contains(int[] nums, int target) {
        for (int num : nums) {
            if (num == target) {
                return true;
            }
        }
        return false;
    }
}
