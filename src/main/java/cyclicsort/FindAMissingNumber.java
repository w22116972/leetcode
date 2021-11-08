package cyclicsort;

import util.Util;

import java.util.ArrayList;
import java.util.List;

import static util.Util.swap;

// from 0 to n instead of 1 to n
public class FindAMissingNumber {
    public static int mathSol(int[] arr) {
        final int n = arr.length;
        int total = 0;
        for (int i = 1; i <= n; i++) {
            total += i;
        }
        for (int j : arr) {
            total -= j;
        }
        return total;
    }

    public static int cyclicSol(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i && nums[i] != nums[nums[i]]) {
                Util.swap(nums, i, nums[i]);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return -1;
//        int i = 0;
//
//        while (i < nums.length) {
//
//            if (nums[i] < nums.length && nums[i] != nums[nums[i]])
//                swap(nums, i, nums[i]);
//            else
//                i++;
//        }
//        for (i = 0; i < nums.length; i++)
//            if (nums[i] != i)
//                return i;
//
//        return nums.length;

    }


}
