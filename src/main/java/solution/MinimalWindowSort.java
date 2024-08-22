package solution;

public class MinimalWindowSort {
    public static int sol(int[] arr) {
        // 1. use 2 pointers to find two out-of-order index from both sides
        // 2. find max and min of this candidate subarray
        // 3. expand this subarray to check whether outside number is also out of order

        int headIndex = 0;
        int tailIndex = arr.length - 1;
        int headWindowIndex = -1;
        int tailWindowIndex = -1;
        while (headIndex < tailIndex) {
            if (headWindowIndex == -1 && arr[headIndex] > arr[headIndex + 1]) {
                headWindowIndex = headIndex;
            } else if (headWindowIndex == -1) {
                headIndex++;
            }
            if (tailWindowIndex == -1 && arr[tailIndex] < arr[tailIndex - 1]) {
                tailWindowIndex = tailIndex;
            } else if (tailWindowIndex == -1) {
                tailIndex--;
            }
            if (headWindowIndex != -1 && tailWindowIndex != -1) {
                break;
            }
        }
        if (headWindowIndex == -1 && tailWindowIndex == -1) {
            return 0;
        }

        // find min and max of subarray
        int minOfSubarray = Integer.MAX_VALUE;
        int maxOfSubarray = Integer.MIN_VALUE;
        for (int i = headWindowIndex; i <= tailWindowIndex; i++) {
            if (arr[i] < minOfSubarray) {
                minOfSubarray = arr[i];
            }
            if (arr[i] > maxOfSubarray) {
                maxOfSubarray = arr[i];
            }
        }
        // expand subarray
        int globalMinIndex = headWindowIndex;
        for (int i = 0; i < headWindowIndex; i++) {
            final int num = arr[i];
            if (num > minOfSubarray) {
                globalMinIndex = i;
                break;
            }
        }

        int globalMaxIndex = tailWindowIndex;
        for (int i = arr.length - 1; i > tailWindowIndex; i--) {
            final int num = arr[i];
            if (num < maxOfSubarray) {
                globalMaxIndex = i;
                break;
            }
        }

        return globalMaxIndex - globalMinIndex + 1;
    }
}
