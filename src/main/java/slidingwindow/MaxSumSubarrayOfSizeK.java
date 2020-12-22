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

        assert findMaxSumSubArray(3, new int[]{2, 1, 5, 1, 3, 2}) == 9;
        assert findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}) == 7;
    }

    public static int findMaxSumSubArray(int k, int[] arr) {
        int maxSum = 0;
        int windowSum = 0;
        int startIndex = 0;
        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
            windowSum += arr[endIndex];
            if (endIndex > k-1) { // if windows is size of k, then we can slide it
                if (windowSum > maxSum) {
                    maxSum = windowSum;
                }
                windowSum -= arr[startIndex];
                startIndex++;
            }
        }

        return maxSum;
    }
}
