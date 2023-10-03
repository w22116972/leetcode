import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class _4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private List<List<Integer>> kSum(int[] nums, int targetSum, int k, int startIndex) {
        List<List<Integer>> result = new LinkedList<>();
        final int listLength = nums.length;
        if (startIndex >= listLength) {
            return result;
        }
        if (k == 2) {
            int left = startIndex;
            int right = listLength - 1;
            while (left < right) {
                long currentSum = nums[left] + nums[right];
                if (currentSum == targetSum) {
                    result.add(List.of(nums[left], nums[right]));
                    // If there is duplicate number
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    // To skip duplicate nums[right]
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if(currentSum < targetSum){
                    left++;
                } else{
                    right--;
                }
            }
        } else {
            for (int i = startIndex; i < listLength - (k-1); i++) {
                // To skip duplicate
                if (i > startIndex && nums[i] == nums[i-1]) {
                    continue;
                }
                List<List<Integer>> kMinus1Sum = kSum(nums, targetSum - nums[i], k - 1, i + 1);
                for (List<Integer> t : kMinus1Sum){
                    t.add(0, nums[i]);
                }
                result.addAll(kMinus1Sum);
            }
        }
        return result;
    }
}
