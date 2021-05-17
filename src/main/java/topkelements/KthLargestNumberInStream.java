package topkelements;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestNumberInStream {

    private final PriorityQueue<Integer> minHeap;
    private final Integer k;

    public KthLargestNumberInStream(int[] arr, int k) {
        this.k = k;
        this.minHeap = new PriorityQueue<>(this.k);
        for (int i: arr) {
            this.add(i);
        }
    }

    public int add(int num) {
        this.minHeap.add(num);
        if (this.minHeap.size() > this.k) {
            this.minHeap.poll();
        }
        return this.minHeap.peek();
    }
}
