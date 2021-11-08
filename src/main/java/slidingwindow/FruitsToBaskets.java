package slidingwindow;

import scala.Char;

import java.util.HashMap;
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
//        assert maxLengthOfSubstringWith2DistinctChars(new char[]{'A', 'B', 'C', 'A', 'C'}) == 3;
//        assert maxLengthOfSubstringWith2DistinctChars(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}) == 5;
//
//        assert sol1(new char[]{'A', 'B', 'C', 'A', 'C'}) == 3;
//        assert sol1(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}) == 5;
    }

    public static int sol1(char[] arr) {
        int maxNumberOfFruits = 0;
        int windowStartIndex = 0;
        ConcurrentHashMap<Character, Integer> basket = new ConcurrentHashMap<>(2);
        for (int windowEndIndex = 0; windowEndIndex < arr.length; windowEndIndex++) {
            final char currentChar = arr[windowEndIndex];
            if (basket.contains(currentChar)) {
                basket.put(currentChar, basket.get(currentChar) + 1);
            } else {
                basket.put(currentChar, 1);
            }
            // check if number of type of fruit is more than 2
            // we have to shrink basket until number of type of fruit is equal to 2
            while (basket.size() > 2) {
                final char startChar = arr[windowStartIndex];
                basket.put(startChar, basket.get(startChar) - 1);
                if (basket.get(startChar) == 0) {
                    basket.remove(startChar);
                }
                windowStartIndex++;
            }
            maxNumberOfFruits = Math.max(maxNumberOfFruits, windowEndIndex - windowStartIndex + 1);
        }
        return maxNumberOfFruits;
    }

    public static int sol(char[] arr) {
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

    public static int practice(char[] arr) {
        // since 2 baskets could only contain one type (distinct) of fruit(char) -> at most 2 distinct char

        // contain distinct char
        HashMap<Character, Integer> window = new HashMap<>();

        // return max length -> declare min length for comparing
        int maxLengthOfSubstring = Integer.MIN_VALUE;

        // declare head index of substring
        int headIndexOfSubstring = 0;

        // declare basket number
        final int basketNumber = 2;

        // declare tail index of substring and start to move window
        for (int tailIndexOfSubstring = 0; tailIndexOfSubstring < arr.length; tailIndexOfSubstring++) {
            // put tail char to window
            final char tailChar = arr[tailIndexOfSubstring];
            if (window.containsKey(tailChar)) {
                window.put(tailChar, window.get(tailChar) + 1);
            } else {
                window.put(tailChar, 1);
            }

            // check correctness after moving tail char in windows
            while (window.size() > basketNumber) {
                // remove head char
                final char headChar = arr[headIndexOfSubstring];
                if (window.get(headChar) == 1) {
                    window.remove(headChar);
                } else {
                    window.put(headChar, window.get(headChar) - 1);
                }
                headIndexOfSubstring++;
            }

            // comparing existing correct length with longest length
            final int currentLengthOfSubstring = tailIndexOfSubstring - headIndexOfSubstring + 1;
            maxLengthOfSubstring = Math.max(currentLengthOfSubstring, maxLengthOfSubstring);
        }
        return maxLengthOfSubstring;
    }
}
