package topkelements;

import java.util.PriorityQueue;

public class ConnectRopes {

    public static int minHeapSol(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(arr.length);
        for (int i: arr) {
            minHeap.add(i);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            final int newRoleLength = minHeap.poll() + minHeap.poll();
            cost += newRoleLength;
            minHeap.add(newRoleLength);
        }
        return cost;
    }
}
