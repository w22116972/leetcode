import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    // The algorithm of this solution is to
    // 1. sort the nums first
    // 2. so that we can fix the first two numbers
    // 3. iterating the rest of the nums with `target - fixed first two numbers` like two sum
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        if (target / 4 > nums[nums.length - 1]) {
            return result;
        }

        // The reason for `< nums.length - 3` is because we need a room for last two numbers
        for (int i = 0; i < nums.length - 3; i++) {
            // since result  of nums[i] * 4 might overflow
            if (target / 4 < nums[i]) {  // To replace `if (target < nums[i] * 4)`
                break;
            }

            // To skip duplicate number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // Starting iteration
                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target) {
                        result.add(List.of(nums[i], nums[j], nums[left], nums[right]));
                        // skip duplicate
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }

    public List<List<Integer>> fourSumUsingNSum(int[] nums, int target) {
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0, nums.length - 1);
    }

    public List<List<Integer>> nSum(int[] nums, long target, int n, int leftIndex, int rightIndex) {
        List<List<Integer>> result = new LinkedList<>();
        if (n < 2 || rightIndex - leftIndex + 1 < n || target / n < nums[leftIndex] || target / n > nums[rightIndex]) {
            return result;
        }
        if (n == 2) {
            int left = leftIndex;
            int right = rightIndex;

            while (left < right) {
                long sum = (long) nums[left] + nums[right];

                if (sum == target) {
                    result.add(Arrays.asList(nums[left], nums[right]));

                    // Skip duplicates
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }

                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        } else {
            // Solve n-Sum problem recursively
            for (int i = leftIndex; i <= rightIndex - n + 1; i++) {
                if (i > leftIndex && nums[i] == nums[i - 1]) {
                    // Skip duplicates
                    continue;
                }
                // key idea is to consider nums[i] and n-1 sum
                List<List<Integer>> subResult = nSum(nums, target - nums[i], n - 1, i + 1, rightIndex);
                // if nums[i] is not the final candidate, then subResult will be empty
                // else we need to add nums[i] to result
                for (List<Integer> tuple : subResult) {
                    final LinkedList<Integer> modifiableTuple = new LinkedList<>(tuple);
                    modifiableTuple.add(0, nums[i]);
                    result.add(modifiableTuple);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        long sum = (long) 1000000000 + 1000000000 + 1000000000 + 1000000000;
        System.out.println("sum = " + sum);

        final FourSum fourSum = new FourSum();
        final List<List<Integer>> answer = fourSum.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
//
//        [1,0,-1,0,-2,2]
//        0
//                [1000000000,1000000000,1000000000,1000000000]
//        -294967296
//                [-1000000000,-1000000000,1000000000,-1000000000,-1000000000]
//        294967296
    }
}
