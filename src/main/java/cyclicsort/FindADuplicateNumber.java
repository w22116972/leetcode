package cyclicsort;

import util.Util;

public class FindADuplicateNumber {
    public static int flipNegativeSol(int[] nums) {
        // since nums[i] is 1 to arr.length
        // nums[i] -> flag index i-1 to negative number

        // 1, 1, 2
        // 1 -> flagIndex = 0 (nums[i] - 1) -> nums[flagIndex] = -1
        // 1 -> flagIndex = 0 (nums[i] - 1) -> nums[flagIndex] < 0 ->

        // 1, 4, 4, 3, 2
        // nums[0] = -1
        // nums[3] =
        for (int i = 0; i < nums.length; i++) {
            int flagIndex = Math.abs(nums[i])-1;
            if (nums[flagIndex] < 0) {
//                System.out.println("nums[flagIndex] = " + nums[flagIndex]);
                return flagIndex + 1;
            }
            nums[flagIndex] = -nums[flagIndex];
        }
        return -1;
    }

    public static int cyclicSol(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                Util.swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        Util.printArray(nums);
        return -1;
    }

    public static void main(String[] args) {
        final int[] nums0 = {1, 1, 2};
        final int[] nums1 = {1, 4, 4, 3, 2};
        final int[] nums2 = {2, 1, 3, 3, 5, 4};
        final int[] nums3 = {2, 4, 1, 4, 4};

        cyclicSort(nums1);
        cyclicSort(nums2);
        cyclicSort(nums3);

//        System.out.println("flipNegativeSol(nums0) = " + flipNegativeSol(nums0));
//        System.out.println("flipNegativeSol(nums1) = " + flipNegativeSol(nums1));
//        System.out.println("flipNegativeSol(nums2) = " + flipNegativeSol(nums2));
//        System.out.println("flipNegativeSol(nums3) = " + flipNegativeSol(nums3));
    }

    public static void cyclicSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                Util.swap(nums, i, nums[i] - 1);
            }
        }
        Util.printArray(nums);
//        return nums;
    }
}
