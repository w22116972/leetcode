package cyclicsort;

import util.Util;

public class FirstMissingPositive {
    public static int sol(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // i = nums[i] - 1
            while (nums[i] > 0 && nums[i] < nums.length && nums[i] != nums[nums[i] - 1]) {
                Util.swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i] - 1) {
                return i + 1;
            }
        }

        // 1, 2, 3, 4 -> return length + 1 == 5
        return nums.length + 1;
    }
}
