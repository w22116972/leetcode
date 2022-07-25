package heap;

import java.util.PriorityQueue;

public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        final PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        for (int i: nums) {
            heap.add(i);
            if (heap.size() == k) {
                heap.poll();
            }
        }
        while (heap.size() != k) {
            heap.poll();
        }
        return heap.poll();
    }
}
