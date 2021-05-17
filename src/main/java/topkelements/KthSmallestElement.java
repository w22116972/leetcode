package topkelements;

import java.util.PriorityQueue;

public class KthSmallestElement {

    // S = O(n)
    // T = O(n * log n + k * log n + 1)
    public static int minHeapSol(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for (int i : arr) {
            minHeap.add(i);
        }
        for (int i = 1; i <= k - 1 ; i++) {
            minHeap.remove();
        }
        return minHeap.peek();
    }


}
