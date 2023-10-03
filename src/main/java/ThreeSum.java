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
}
