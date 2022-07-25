package design;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// Use two lists
// - ArrayList with hash key as set
// - LinkedList as bucket
public class TwoArrayHashSet {
    public List<List<Integer>> hashSet;

    public TwoArrayHashSet() {
        this.hashSet = new ArrayList<>(10001);
        for (int i = 0; i <= 10000; i++) {
            this.hashSet.add(new LinkedList<>());
        }
    }

    public void add(int key) {
        final int hashValue = hash(key);
        final List<Integer> existingList = this.hashSet.get(hashValue);
        existingList.add(key);
        this.hashSet.set(hashValue, existingList);
    }

    public void remove(int key) {
        final int hashValue = hash(key);
        final List<Integer> existingList = this.hashSet.get(hashValue);
        if (existingList != null) {
            while (existingList.contains(key)) {
                existingList.remove(Integer.valueOf(key));
            }
        }

    }

    public boolean contains(int key) {
        final int hashValue = hash(key);
        final List<Integer> existingList = this.hashSet.get(hashValue);
        for (int i : existingList) {
            if (key == i) {
                return true;
            }
        }
        return false;
    }

    private int hash(int value) {
        return value % 10000;
    }

    public static void main(String[] args) {
        final TwoArrayHashSet twoArrayHashSet = new TwoArrayHashSet();
        System.out.println(twoArrayHashSet.hashSet.size());
    }
}
