package slidingwindow;

//Given an array, find the average of all contiguous subarrays of size ‘K’ in it.
// input: Array=[1, 3, 2, 6, -1, 4, 1, 8, 2], K=5
// output: [2.2, 2.8, 2.4, 3.6, 2.8]

public class AverageOfContiguousSubarrayOfSizeK {

    public static void main(String[] args) {
        final double[] averages2 = findAverages2(5, new int[]{1, 3, 2, 6, -1, 4, 1, 8, 2});
        for (double v : averages2) {
            System.out.println(v);
        }
    }

    public static double[] findAverages2(int k, int[] arr) {
        double[] result = new double[arr.length - k + 1];
        double windowSum = 0;
        int startIndex = 0;
        for (int i = startIndex; i < k; i++) {
            windowSum += arr[i];
        }
        result[startIndex] = windowSum/k;
        for (int endIndex = k; endIndex < arr.length; endIndex++) {
            windowSum -= arr[startIndex];
            windowSum += arr[endIndex];
            startIndex++;
            result[startIndex] = windowSum / k;
        }
        return result;
    }

    public static double[] findAverages(int k, int[] arr) {
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


//        double[] result = new double[arr.length - K + 1];
//        double windowSum = 0;
//        int windowStart = 0;
//        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
//            windowSum += arr[windowEnd]; // add the next element
//            // slide the window, we don't need to slide if we've not hit the required window size of 'k'
//            if (windowEnd >= K - 1) {
//                result[windowStart] = windowSum / K; // calculate the average
//                windowSum -= arr[windowStart]; // subtract the element going out
//                windowStart++; // slide the window ahead
//            }
//        }
        return result;
    }
}
