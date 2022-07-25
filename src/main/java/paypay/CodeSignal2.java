package paypay;

import java.util.*;

public class CodeSignal2 {
    public int Solution(String beginWord, String endWord, String[] wordList) {
        Set<String> wordSet = new HashSet<>(Arrays.asList(wordList));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int length = 1;
        while (!queue.isEmpty()) {
            final int currentLevelSize = queue.size();
            for (int i = 0; i < currentLevelSize; i++) {
                final String word = queue.poll();
                if (endWord.equals(word)) {
                    return length;
                }

                for (int currentWordIndex = 0; currentWordIndex < word.length(); currentWordIndex++) {
                    char[] chars = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        // replace char
                        chars[currentWordIndex] = c;
                        final String newWord = String.valueOf(chars);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            visited.add(newWord);
                            queue.offer(newWord);
                        }
                    }
                }
            }
            System.out.println("length = " + length);
            length++;
        }
        return 0;
    }

    public static void main(String[] args) {
        final CodeSignal2 sol = new CodeSignal2();
        System.out.println("sol = " + sol.Solution("hit", "cog", new String[]{"hot",
                "dot",
                "dog",
                "lot",
                "log",
                "cog"}));
    }
}
