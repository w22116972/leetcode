import java.util.Arrays;

public class ThreeSumClosest {

    // The goal is to find triplet sum which is closet to target value
    // i.e. x + y + z ~= target, y + z = min {|target - x|}
    // We have to store two variables, one is current minimal difference and the other one is current triplet sum

    public static int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        // if these 2 vars are local, we can't define new function to find pair
        int minDiff = Integer.MAX_VALUE;;
        int closetSum = target;
        for (int x = 0; x < nums.length - 2; x++) {
            int y = x + 1;
            int z = nums.length - 1;
            while (y < z) {
                final int currentSum = nums[x] + nums[y] + nums[z];
                final int currentDiff = Math.abs(target - currentSum);
                if (currentDiff == 0) {
                    return target;
                } else if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                    closetSum = currentSum;
                }
                if (currentSum < target) {
                    y++;
                    while (y < z && nums[y] == nums[y - 1]) {
                        y++;
                    }
                } else { //currentSum > target
                    z--;
                    while (y < z && nums[z] == nums[z + 1]) {
                        z--;
                    }
                }
            }
        }
        return closetSum;
    }

    // Since we have to return sum of triplets and measure triplets by minimal difference,
    // we need two variables for storing sum and difference.
    // First, we start from x to length of array minus - 2 (because we have to keep last two value for y and z)
    // y is starting from beginning of array, while z is starting from end of the array
    // Then we calculate the sum of triplets and difference between target
    // if target is equal to sum of triplets which means difference is zero, then we return sum directly
    // else if difference is less than minimal difference, then we have to update it
    // Finally we have to decide which index should move,
    //  if sum of triplets is greater than target, it means that we have to cut sum by z--
    // else we have to increase sum by y++
    public static int sol(int[] arr, int target) {
        int resultSum = 0;
        int minDiffer = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int x = 0; x < arr.length - 2; x++) {
            int y = x + 1;
            int z = arr.length - 1;
            while (y < z) {
                final int currentSum = arr[x] + arr[y] + arr[z];
                final int differ = Math.abs(target - currentSum);
                if (differ == 0) {
                    return target;
                } else if (differ < minDiffer) { //
                    resultSum = currentSum;
                    minDiffer = differ;
                }
                if (currentSum < target) {
                    y++;
                } else { //currentSum > target
                    z--;
                }
            }
        }
        return resultSum;
    }

    public static int getTripletSumCloseToTarget(int[] arr, int target) {

        Arrays.sort(arr);
        int minDiff = Integer.MAX_VALUE;
        for (int x = 0; x < arr.length - 2; x++) {
            int y = x + 1;
            int z = arr.length - 1;
            while (y < z) {
                int currentSum = arr[x] + arr[y] + arr[z];
                int currentDiff = Math.abs(target - currentSum);
                if (currentDiff == 0) {
                    return target;
                }
                if (currentDiff < minDiff) {
                    minDiff = currentDiff;
                }
                if (target > currentSum) { // current sum need to be bigger
                    y++;
                } else {
                    z--;
                }
            }
        }
        return target - minDiff;
    }

}
