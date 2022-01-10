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
        int oldFreq = keyToFreq.get(key);
        // update keyToFreq
        keyToFreq.remove(key);
        int newFreq = oldFreq + 1;
        keyToFreq.put(key, newFreq);
        // update freqToKeys
        // remove old key in freqToKeys
        freqToKeys.get(oldFreq).remove(key);
        // if oldFreq == minFreq and only one ele in freqToKeys
        if (oldFreq == minFreq && freqToKeys.get(oldFreq).isEmpty()) {
            minFreq = newFreq;
            freqToKeys.remove(oldFreq);
        }
        // add new freq with key to freqToKeys
        freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());
        final LinkedHashSet<Integer> keys = freqToKeys.get(newFreq);
        keys.add(key);
        freqToKeys.put(newFreq, keys);
//        freqToKeys.get(newFreq).add(key);

        return keyToValue.get(key);
    }

    public void put(int key, int value) {
        if (capacity == keyToValue.size()) {
            int freq = keyToFreq.get(key);
            final LinkedHashSet<Integer> keys = freqToKeys.get(minFreq);
            int oldestKeyByMinFreq = keys.stream().findFirst().get();

        }
        // now it is safe to put
        // update keyToValue
        keyToValue.put(key, value);

        if (keyToFreq.containsKey(key)) {  // this is old key
            int oldFreq = keyToFreq.get(key);
            int newFreq = oldFreq + 1;
            keyToFreq.put(key, newFreq);
            freqToKeys.get(oldFreq).remove(key);
            if (freqToKeys.get(oldFreq).size() == 0) {
                freqToKeys.remove(oldFreq);
                if (minFreq == oldFreq) {
                    minFreq = newFreq;
                }
            }

            final LinkedHashSet<Integer> keys = freqToKeys.get(newFreq);
            keys.add(key);
            freqToKeys.put(newFreq, keys);

        } else {
            int newFreq = 1;
            keyToFreq.put(key, newFreq);
            minFreq = newFreq;
            freqToKeys.putIfAbsent(newFreq, new LinkedHashSet<>());

            final LinkedHashSet<Integer> keys = freqToKeys.get(newFreq);
            keys.add(key);
            freqToKeys.put(newFreq, keys);
        }
    }
}
