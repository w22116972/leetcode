package solution;

import java.util.LinkedList;
import java.util.List;

// Subarray Product Less Than K
public class ContSubarrayProductLessThanTarget {

    public static List<List<Integer>> getSubarray(int[] arr, int target) {
        List<List<Integer>> result = new LinkedList<>();
        int currentProduct = 1;
        int head = 0;
        // Sliding window is consist of head and tail
        for (int tail = 0; tail < arr.length; tail++) {
            currentProduct *= arr[tail];
            while (currentProduct >= target && head < arr.length) {
                currentProduct /= arr[head];
                head++;
            }
            // Now Product of any combination of numbers from head to tail are all < target
            List<Integer> tempList = new LinkedList<>();
            for (int i = tail; i >= head; i--) {
                tempList.add(0, arr[i]);
                result.add(new LinkedList<>(tempList));
            }
        }
        return result;

    }

    public static void main(String[] args) {
        System.out.println(
                ContSubarrayProductLessThanTarget.getSubarray(new int[] { 2, 5, 3, 10 }, 30));
        System.out.println(
                ContSubarrayProductLessThanTarget.getSubarray(new int[] { 8, 2, 6, 5 }, 50));
    }
}
