package sort;

import java.util.*;
import java.util.stream.Collectors;

public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word: words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }


//        map.entrySet().stream().sorted();

        final Comparator<Map.Entry<String, Integer>> comparator = Map.Entry.comparingByValue();
        final Comparator<Map.Entry<String, Integer>> reversed = comparator.reversed();
        final Comparator<Map.Entry<String, Integer>> finalComparator = reversed.thenComparing(Map.Entry::getKey);
        return map.entrySet().stream().sorted(finalComparator).limit(k).map(Map.Entry::getKey).collect(Collectors.toList());


//        comparator = comparator.thenComparing(Comparator.comparing(person -> person.age));
    }


}
