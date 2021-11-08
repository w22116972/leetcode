package topkelements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SumOfElements {

    // T = O(N ∗ logN)
    // 找出第bigK小的 -> maxHeap with size=bigK
    public static int sol(int[] arr, int k1, int k2) {
        final int smallK = Math.min(k1, k2);
        final int bigK = Math.max(k1, k2);
        final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(bigK, Comparator.reverseOrder());
        for (int i: arr) {
            maxHeap.add(i);
            if (maxHeap.size() > bigK) {
                maxHeap.poll();
            }
        }
        maxHeap.poll(); // pop bigK th element
        int count = 0;
        for (int i = 0; i < bigK - smallK - 1 ; i++) {
            count += maxHeap.poll();
        }
        return count;
    }
}

