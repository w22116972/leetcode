package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        // assume x + y + z = 0 -> y + z = -x
        for (int xIndex = 0; xIndex < nums.length - 2; xIndex++) {
            final int x = nums[xIndex];
            // to skip same x
            if (hasSameX(nums, xIndex)) {
                continue;
            }
            twoSum(nums, -x, xIndex + 1, result);
        }
        return result;
    }

    public boolean hasSameX(int[] nums, int xIndex) {
        return xIndex >= 1 && nums[xIndex] == nums[xIndex-1];
    }

    public void twoSum(int[] nums, int target, int headIndex, List<List<Integer>> result) {
        int yIndex = headIndex;
        int zIndex = nums.length - 1;
        while (yIndex < zIndex) {
            final int currentSum = nums[yIndex] + nums[zIndex];
            if (currentSum == target) {
                int x = -target;
                int y = nums[yIndex];
                int z = nums[zIndex];
                result.add(List.of(x, y, z));
                yIndex++;
                zIndex--;
                // skip duplicate y
                while (yIndex < zIndex && nums[yIndex] == nums[yIndex - 1]) {
                    yIndex++;
                }
                // skip duplicate z
                while (yIndex < zIndex && nums[zIndex] == nums[zIndex + 1]) {
                    zIndex--;
                }

            } else if (currentSum < target) {
                yIndex++;
            } else if (currentSum > target) {
                zIndex--;
            }
        }
    }

    public List<List<Integer>> threeLargeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        int n = nums.length;

        // i + j + k = 0
        for (int i = 0; i < n - 2; i++) {
            // To skip duplicate nums[i]
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;

            while (j < k) {
                // To check overflow: nums[i] + nums[j] > INTEGER.MAX_VALUE ?
                if (nums[i] > Integer.MAX_VALUE - nums[j]) {
                    j++;
                    continue;
                }
                // To check overflow: nums[i] + nums[j] + nums[k] > INTEGER.MAX_VALUE ?
                if (nums[i] + nums[j] > Integer.MAX_VALUE - nums[k]) {
                    k--;
                    continue;
                }
                int threeSum = nums[i] + nums[j] + nums[k];
                if (threeSum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    // To skip duplicate nums[j]
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    // To skip duplicate nums[k]
                    while (j < k && k != n - 1 && nums[k] == nums[k + 1]) {
                        k--;
                    }


                } else if (threeSum < 0) { // Should larger, so move j to right
                    j++;
                } else { // Should smaller, so move k to left
                    k--;
                }

            }

        }



        return result;
    }
}
