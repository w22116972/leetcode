package topkelements;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class TopKFrequentNumber {

    // T = O(n + n * log n + k)
    public static List<Integer> hashMapWithHeapSol(int[] arr, int k) {
        // 1. put all number by freq
        ConcurrentHashMap<Integer, Integer> numberToFrequent = new ConcurrentHashMap<>(arr.length);
        for (int i: arr) {
            numberToFrequent.put(i, numberToFrequent.getOrDefault(i, 0) + 1);
        }

        // 2. put all entries in map to max heap according to entry's value
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(numberToFrequent.size(),
                (map1, map2) -> map2.getValue() - map1.getValue());
        maxHeap.addAll(numberToFrequent.entrySet());

        // 3. Poll k number entries from maxHeap and return
        final ArrayList<Integer> result = new ArrayList<>(k);
        while (k-- > 0) {
            result.add(maxHeap.poll().getKey());
        }
        return result;
    }
}
