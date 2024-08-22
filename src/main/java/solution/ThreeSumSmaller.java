package solution;

import java.util.Arrays;

public class ThreeSumSmaller {

    // The goal is to find how many sum of 3 numbers in array less than target value


    public static int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int xIndex = 0; xIndex < nums.length - 2; xIndex++) {
            int yIndex = xIndex + 1;
            int zIndex = nums.length - 1;
            while (yIndex < zIndex) {
                final int currentSum = nums[xIndex] + nums[yIndex] + nums[zIndex];
                if (currentSum < target) {
                    // Current yIndex with all subsequent zIndex are fit
                    count += (zIndex - yIndex);
                    yIndex++;
                } else {
                    zIndex--;
                }
            }
        }
        return count;
    }




    public static int countTripletSumLessThanTarget(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        for (int x = 0; x < nums.length - 2; x++) {
            int y = x + 1;
            int z = nums.length - 1;
            while (y < z) {
                int currentSum = nums[x] + nums[y] + nums[z];
                if (currentSum < target) {
                    count+= (y-z);
                    y++;
                }
                else {
                    z--;
                }
            }
        }
        return count;
    }
}
