package heap;

import java.util.*;

public class TaskScheduler {
    public int test(char[] tasks, int n) {
        if (n == 0) {
            return tasks.length;
        }

        HashMap<Character, Integer> charToCount = new HashMap<>();
        // O(n)
        for (char task: tasks) {
            if (charToCount.containsKey(task)) {
                charToCount.put(task, charToCount.get(task) + 1);
            } else {
                charToCount.put(task, 1);
            }
        }

        // O(n)
        final LinkedList<Entry> list = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry: charToCount.entrySet()) {
            list.add(new Entry(entry.getKey(), 1, entry.getValue()));
        }
        // O(nlogn)
        list.sort((e1, e2) -> e2.count - e1.count);
        int intervalLength = 1;
        int currentIndex = 0;
        while (!list.isEmpty()) {
            System.out.println(list);
            while (list.get(currentIndex).index > intervalLength) {
                currentIndex++;
                // there is no entry can insert at this position, so make it idle (i++) and start over again
                if (currentIndex >= list.size()) {
                    intervalLength++;
                    currentIndex = 0;
                }
            }
            // find the appropriate index to insert
            final Entry currentTask = list.get(currentIndex);
            currentTask.count--;
            if (currentTask.count == 0) {
                list.remove(currentIndex);
            } else {
                currentTask.index += (n + 1);
            }
            intervalLength++;
            currentIndex = 0;
        }

        return intervalLength - 1;
    }

    public static void main(String[] args) {
        System.out.println(new TaskScheduler().test(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
    }


    public int leastInterval(char[] tasks, int n) {
//        final LinkedHashMap<Object, Object> objectObjectLinkedHashMap = new LinkedHashMap<>();
        HashMap<Character, Integer> charToCount = new HashMap<>();
        for (char task: tasks) {
            if (charToCount.containsKey(task)) {
                charToCount.put(task, charToCount.get(task) + 1);
            } else {
                charToCount.put(task, 1);
            }
        }

        PriorityQueue<Entry> maxHeap = new PriorityQueue<>((e1, e2) -> e2.count - e1.count);
        for (Map.Entry<Character, Integer> entry: charToCount.entrySet()) {
            maxHeap.add(new Entry(entry.getKey(), 1, entry.getValue()));
        }

        List<Entry> tempEntries = new LinkedList<>();

        int i = 1;
        while (!maxHeap.isEmpty()) {
            while (maxHeap.peek().index > i) {
                tempEntries.add(maxHeap.poll());
                if (maxHeap.isEmpty()) {
                    i++;
                    maxHeap.addAll(tempEntries);
                }
            }
            // now peek of maxHeap is ok to insert at position i
            Entry entry = maxHeap.poll();
            entry.index += n;
            entry.count--;
            if (entry.count != 0) {
                maxHeap.add(entry);
            }
            maxHeap.addAll(tempEntries);

            i++;
        }
        return i;
    }

    static class Entry {
        char c; // letter
        int index; // next available index
        int count;

        public Entry(char c, int index, int count) {
            this.c = c;
            this.index = index;
            this.count = count;
        }

        @Override
        public String toString() {
            return c + "(index=" + index + ", count=" + count + ")";
        }
    }


}
