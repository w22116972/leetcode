package topkelements;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FrequencySort {

    public static String sol(String input) {
        // 1. Put chars to charToFreq
        LinkedHashMap<Character, Integer> charToFrequency = new LinkedHashMap<>(input.length());
        for (char c: input.toCharArray()) {
            charToFrequency.put(c, charToFrequency.getOrDefault(c, 0) + 1);
        }

        // 2. create max heap sorted by value
        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(charToFrequency.size(),
                (map1, map2) -> map2.getValue() - map1.getValue());

        // 3. put chars and frequency to max heap
//        charToFrequency.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            maxHeap.add(Map.entry(k, v));
//        });
        maxHeap.addAll(charToFrequency.entrySet());
        charToFrequency.entrySet().forEach(System.out::println);

        // 4. poll entry from max heap and form a string
        final StringBuilder stringBuilder = new StringBuilder();
        while (maxHeap.size() != 0) {
            final Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
//                System.out.println("poll.getKey() = " + poll.getKey());
                stringBuilder.append(entry.getKey());
            }
        }
        System.out.println("stringBuilder.toString() = " + stringBuilder.toString());
        return stringBuilder.toString();
    }

    public static String grokkingSol(String input) {
        Map<Character, Integer> characterFrequencyMap = new HashMap<>();
        for (char chr : input.toCharArray()) {
            characterFrequencyMap.put(chr, characterFrequencyMap.getOrDefault(chr, 0) + 1);
        }

        PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>(
                (e1, e2) -> e2.getValue() - e1.getValue());

        // add all characters to the max heap
        maxHeap.addAll(characterFrequencyMap.entrySet());

        // build a string, appending the most occurring characters first
        StringBuilder sortedString = new StringBuilder(input.length());
        while (!maxHeap.isEmpty()) {
            Map.Entry<Character, Integer> entry = maxHeap.poll();
            for (int i = 0; i < entry.getValue(); i++) {
                System.out.println("entry.getKey() = " + entry.getKey());
                sortedString.append(entry.getKey());
            }
        }
        return sortedString.toString();
    }
}
