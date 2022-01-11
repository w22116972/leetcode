package design;

import java.util.HashMap;
import java.util.LinkedHashSet;

public class LfuCache {

    HashMap<Integer, Integer> keyToValue;
    HashMap<Integer, Integer> keyToFreq;
    HashMap<Integer, LinkedHashSet<Integer>> freqToKeys;
    Integer minFreq = 0;
    Integer capacity;

    public LfuCache(int capacity) {
        this.capacity = capacity;
        this.keyToValue = new HashMap<>(capacity);
        this.keyToFreq = new HashMap<>(capacity);
        this.freqToKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToValue.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToValue.get(key);
    }

    private void removeMinFreqKey() {
        final LinkedHashSet<Integer> keysByMinFreq = freqToKeys.get(minFreq);
        int oldestKeyByMinFreq = keysByMinFreq.stream().findFirst().get();
        keysByMinFreq.remove(oldestKeyByMinFreq);
        if (keysByMinFreq.isEmpty()) {
            freqToKeys.remove(minFreq);
        }
        keyToValue.remove(oldestKeyByMinFreq);
        keyToFreq.remove(oldestKeyByMinFreq);
    }

    private void increaseFreq(int key) {
        final int oldFreq = keyToFreq.get(key);
        final int newFreq = oldFreq + 1;
        // update keyToFreq
        keyToFreq.put(key, newFreq);

        // update freqToKeys for oldFreq
        final LinkedHashSet<Integer> keysByOldFreq = freqToKeys.get(oldFreq);
        keysByOldFreq.remove(key);
        freqToKeys.put(oldFreq, keysByOldFreq);
        // update freqToKeys for newFreq
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        final LinkedHashSet<Integer> keysByNewFreq = freqToKeys.get(newFreq);
        keysByNewFreq.add(key);
        freqToKeys.put(newFreq, keysByNewFreq);

        // check empty case
        if (freqToKeys.get(oldFreq).isEmpty()) {
            freqToKeys.remove(oldFreq);
            if (oldFreq == minFreq) {
                minFreq++;
            }
        }
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToValue.containsKey(key)) {
            keyToValue.put(key, value);
            increaseFreq(key);
            return;
        }
        // if key is not existing in cache

        if (capacity <= keyToValue.size()) {
            removeMinFreqKey();
        }
        keyToValue.put(key, value);
        keyToFreq.put(key, 1);
        freqToKeys.putIfAbsent(1, new LinkedHashSet<>());
        freqToKeys.get(1).add(key);
        minFreq = 1;
    }

    // ["LFUCache","put","put","put","put","get"]
    //[[2],[3,1],[2,1],[2,2],[4,4],[2]]

//    ["LFUCache","put","get"]
//            [[0],[0,0],[0]]

    public static void main(String[] args) {
        final LfuCache cache = new LfuCache(0);
        cache.put(0, 0);
        cache.get(0);

//        final LfuCache cache = new LfuCache(2);
//        cache.put(3, 1);
//        cache.put(2, 1);
//        cache.put(2, 2);
//        cache.put(4, 4);
//        cache.get(2);
    }
}
