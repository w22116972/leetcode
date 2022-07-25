package hashtable;


import java.util.*;

// Use a min heap to store sum of index and corresponding string
// Use a hashSet to store their common restaurant
public class MinimumIndexSumOfTwoLists {
    public String[] findRestaurant(String[] list1, String[] list2) {
        final PriorityQueue<HeapEntry> minHeap = new PriorityQueue<>(new MyComparator());
        final HashMap<String, Integer> restToIndex = new HashMap<>();

        for (int i = 0; i < list1.length; i++) {
            restToIndex.put(list1[i], i);
        }


        for (int i = 0; i < list2.length; i++) {
            final String s = list2[i];
            if (restToIndex.containsKey(s)) {
                minHeap.add(new HeapEntry(i + restToIndex.get(s), s));
            }
        }
        int sameIndex = -1;
        final LinkedList<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            final HeapEntry entry = minHeap.poll();
            if (sameIndex == -1) {
                sameIndex = entry.indexSum;
            } else if (entry.indexSum != sameIndex) {
                break;
            }
            result.add(entry.restaurant);
        }
        return result.toArray(new String[0]);
    }

    static class HeapEntry {
        Integer indexSum;
        String restaurant;

        public HeapEntry(Integer indexSum, String restaurant) {
            this.indexSum = indexSum;
            this.restaurant = restaurant;
        }
    }

    static class MyComparator implements Comparator<HeapEntry> {
        public int compare(HeapEntry entry1, HeapEntry entry2) {
            return entry1.indexSum.compareTo(entry2.indexSum);
        }
    }

}
