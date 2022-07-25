package design;

import java.util.PriorityQueue;

public class KthLargestElementInStream {

    private final PriorityQueue<Integer> minHeap;
    private final Integer maxSize;

    public KthLargestElementInStream(int k, int[] nums) {
        maxSize = k;
        minHeap = new PriorityQueue<>();
        int i = 0;
        while (i < nums.length) {
            int n = nums[i];
            if (minHeap.size() == maxSize && n >= minHeap.peek()) {
                minHeap.poll();
            }
            if (minHeap.size() < maxSize) {
                minHeap.add(n);
            }
            i++;
        }
    }
    public int add(int val) {
        if (minHeap.size() == maxSize && val >= minHeap.peek()) {
            minHeap.poll();
        }
        if (minHeap.size() < maxSize) {
            minHeap.add(val);
        }
        return minHeap.peek();
    }
}
