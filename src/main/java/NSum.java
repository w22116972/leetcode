import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class NSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, 4, 0, 0);
    }

    public List<List<Integer>> nSum(int[] nums, int n , int startIndex, int target) {
        int size = nums.length;
        final List<List<Integer>> result = new LinkedList<>();
        if (n < 2 || size < n) {
            return result;
        }
        if (n == 2) {
            int headIndex = startIndex;
            int tailIndex = size - 1;
            while (headIndex < tailIndex) {
                final int headValue = nums[headIndex];
                final int tailValue = nums[tailIndex];
                final int sum = headValue + tailValue;

                if (sum < target) {
                    while (headIndex < tailIndex && nums[headIndex] == headValue) {
                        headIndex++;
                    }
                } else if (sum > target) {
                    while (headIndex < tailIndex && nums[tailIndex] == tailValue) {
                        tailIndex--;
                    }
                } else { // sum == target
                    result.add(List.of(headValue, tailValue));
                    while (headIndex < tailIndex && nums[headIndex] == headValue) {
                        headIndex++;
                    }
                    while (headIndex < tailIndex && nums[tailIndex] == tailValue) {
                        tailIndex--;
                    }
                }
            }
        } else {  // n > 2
            for (int i = startIndex; i < size; i++) {
                List<List<Integer>> localResult = nSum(nums, n - 1, i + 1, target - nums[i]);
                for (int j = 0; j < localResult.size(); j++) {
                    final List<Integer> list = localResult.get(j);
                    localResult.get(j).add(nums[i]);
                    result.add(localResult.get(j));
                }
//                for (List<Integer> list: localResult) {
//                    list.add(nums[i]);
//                    result.add(list);
//                }
                while (i < size - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }

        return result;
    }
}
