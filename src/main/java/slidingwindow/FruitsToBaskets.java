package slidingwindow;

import java.util.concurrent.ConcurrentHashMap;

/*
        Problem Statement
        Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
        You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
        Write a function to return the maximum number of fruits in both the baskets.
        Example 1:
        Input: Fruit=['A', 'B', 'C', 'A', 'C']
        Output: 3
        Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']
        Example 2:
        Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
        Output: 5
        Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
        This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
*/
public class FruitsToBaskets {
    public static void main(String[] args) {
        assert maxLengthOfSubstringWith2DistinctChars(new char[]{'A', 'B', 'C', 'A', 'C'}) == 3;
        assert maxLengthOfSubstringWith2DistinctChars(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}) == 5;
    }

    public static int maxLengthOfSubstringWith2DistinctChars(char[] arr) {
        int maxLength = 0;
        int windowsStart = 0;
        final ConcurrentHashMap<Character, Integer> basket = new ConcurrentHashMap<>();
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            final char addedFruit = arr[windowEnd];
            basket.put(addedFruit, basket.getOrDefault(addedFruit, 0) + 1);
            while (basket.size() > 2) {
                final char removedFruit = arr[windowsStart];
                basket.put(removedFruit, basket.get(removedFruit)-1);
                if (basket.get(removedFruit) == 0) {
                    basket.remove(removedFruit);
                }
                windowsStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowsStart + 1);
        }
        return maxLength;
    }
}
