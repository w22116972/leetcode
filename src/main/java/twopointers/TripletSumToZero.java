package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Problem Statement
//        Given an array of unsorted numbers, find all unique triplets in it that add up to zero.
//        Example 1:
//        Input: [-3, 0, 1, 2, -1, 1, -2]
//        Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
//        Explanation: There are four unique triplets whose sum is equal to zero.
//        Example 2:
//        Input: [-5, 2, -1, -2, 3]
//        Output: [[-5, 2, 3], [-2, -1, 3]]
//        Explanation: There are two unique triplets whose sum is equal to zero.
public class TripletSumToZero {
    public static List<List<Integer>> findTriplet(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplet = new ArrayList<>();
        for (int x = 0; x < arr.length - 2; x++) {
            if (x >= 1 && arr[x] == arr[x-1]) { //
                continue;
            }
            // k = -x
            // y = x+1開始找
            findPairOfTargetSum(arr, -arr[x], x+1, triplet);
        }
        return triplet;
    }

    public static void findPairOfTargetSum(int[] arr, int k, int start, List<List<Integer>> triplet) {
        int end = arr.length - 1;
        while (start < end) {
            int currentSum = arr[start] + arr[end];
            if (currentSum == k) {
                triplet.add(Arrays.asList(-k, arr[start], arr[end]));
                start++;
                end--;
                // dedup
                // skip start if dup
                while (start < end && arr[start] == arr[start-1]) {
                    start++;
                }
                // skip end if dup
                while (start <end && arr[end] == arr[end+1]) {
                    end--;
                }
            } else if (k > currentSum) {
                start++;
            } else if (k <= currentSum) {
                end--;
            }
        }
    }

    public static void main(String[] args) {
        int[] input1 = new int[]{-3, 0, 1, 2, -1, 1, -2};
        int[] input2 = new int[]{-5, 2, -1, -2, 3};


    }

}
