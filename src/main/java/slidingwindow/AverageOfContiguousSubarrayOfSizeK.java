package slidingwindow;

//Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
// input: Array=[1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
// output: [2.2, 2.8, 2.4, 3.6, 2.8]

public class AverageOfContiguousSubarrayOfSizeK {
    public static double[] sol(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int windowStartIndex = 0;
        for (int windowEndIndex = 0; windowEndIndex < arr.length; windowEndIndex++) {
            windowSum += arr[windowEndIndex];
            //
            if (windowEndIndex - windowStartIndex + 1 >= k) { // when windows size is k
                result[windowStartIndex] = windowSum / k;
                windowSum -= arr[windowStartIndex];
                windowStartIndex++;
            }
        }
        return result;
    }

    @Deprecated
    public static double[] sol22(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int startIndex = 0;
        for (int endIndex = 0; endIndex < arr.length; endIndex++) {
            windowSum += arr[endIndex];
            if (endIndex >= k-1) { // when windows size is k, then move both index and store result
                result[startIndex] = windowSum / k;
                windowSum-=arr[startIndex];
                startIndex++;
            }
        }
        return result;
    }

    public static double[] practice(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int start = 0;
        for (int end = 0; end < arr.length; end++) {
            windowSum += arr[end];
            if (end - start + 1 >= k) {
                // compute result
                result[start] = windowSum / k;
                // start moves
                windowSum -= arr[start];
                start += 1;
            }
        }
        return result;
    }
}
