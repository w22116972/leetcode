package slidingwindow;
// Given an array of positive numbers and a positive number ‘k’, find the maximum sum of any contiguous subarray of size ‘k’.
// Input: [2, 1, 5, 1, 3, 2], k=3
// Output: 9
// Explanation: Subarray with maximum sum is [5, 1, 3].
//Input: [2, 3, 4, 1, 5], k=2
//Output: 7
//Explanation: Subarray with maximum sum is [3, 4].
public class MaxSumSubarrayOfSizeK {
    public static void main(String[] args) {

        final int testK1 = 3;
        final int[] testArr1 = new int[]{2, 1, 5, 1, 3, 2};
        final int testK2 = 2;
        final int[] testArr2 = new int[]{2, 3, 4, 1, 5};
        System.out.println(findMaxSumSubArray(testK1, testArr1));
        assert findMaxSumSubArray(testK1, testArr1) == 9;
        assert findMaxSumSubArray(testK2, testArr2) == 7;

        assert sol2(testK1, testArr1) == 9;
        assert sol2(testK2, testArr2) == 7;


    }

    public static int sol2(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int windowStartIndex = 0;
        for (int windowEndIndex = 0; windowEndIndex < arr.length; windowEndIndex++) {
            windowSum += arr[windowEndIndex];
            if (windowEndIndex - 0 + 1 >= k) {
                if (windowSum > maxSum) {
                    maxSum = windowSum;
                }
                windowSum -= arr[windowStartIndex];
                windowStartIndex++;
            }
        }
        return maxSum;
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int startIndex = 0;
        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
            windowSum += arr[endIndex];
            if (endIndex >= k-1) { // if windows is size of k, then we can slide it
                if (windowSum > maxSum) {
                    maxSum = windowSum;
                }
                windowSum -= arr[startIndex];
                startIndex++;
            }
        }

        return maxSum;
    }

    public static int practice(int k, int[] arr) {
        int maxLengthOfSubarray = k;

        // find max sum -> declare min then compare
        int maxSumOfSubarray = Integer.MIN_VALUE;

        // declare sum of subarray
        int sumOfSubarray = 0;

        // declare head index of subarray
        int headIndexOfSubarray = 0;

        // declare tail index of subarray and move window
        for (int tailIndexOfSubarray = 0; tailIndexOfSubarray < arr.length; tailIndexOfSubarray++) {
            // add tail to window
            sumOfSubarray += arr[tailIndexOfSubarray];
            // validate subarray
            final int lengthOfSubarray = tailIndexOfSubarray - headIndexOfSubarray + 1;
            if (lengthOfSubarray > maxLengthOfSubarray) {
                sumOfSubarray -= arr[headIndexOfSubarray];
                headIndexOfSubarray++;
            }
            // compare sum of subarray
            maxSumOfSubarray = Math.max(maxSumOfSubarray, sumOfSubarray);
        }
        return maxSumOfSubarray;
    }
}
