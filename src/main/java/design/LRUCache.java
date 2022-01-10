package design;

import java.util.LinkedHashMap;

public class LRUCache {

    private final int capacity;
    private final LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        // accessOrder=true -> reorder after accessing
        this.cache = new LinkedHashMap<>(this.capacity, 0.75f, true);
    }

    public int get(int key) {
        Integer value = this.cache.get(key);
        if (value == null) {
            return -1;
        }
        return value;
    }

    public void put(int key, int value) {
        if (!this.cache.containsKey(key) && this.cache.size() == this.capacity) {
            // remove top linked list element
            this.cache.remove(this.cache.keySet().stream().findFirst().get());
        }
        this.cache.put(key, value);
    }
}
