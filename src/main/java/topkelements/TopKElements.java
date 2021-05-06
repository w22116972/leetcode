package topkelements;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class TopKElements {


    public static List<Integer> minHeapSol(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            minHeap.add(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.add(nums[i]);
            }
        }
        return new ArrayList<>(minHeap);
    }
}
