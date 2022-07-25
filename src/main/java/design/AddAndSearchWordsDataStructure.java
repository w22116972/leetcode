package design;

// - 1 <= word.length <= 25
// - word in addWord consists of lowercase English letters.
// - word in search consist of '.' or lowercase English letters.
// - There will be at most 3 dots in word for search queries.
// - At most 104 calls will be made to addWord and search.

import java.util.HashMap;

public class AddAndSearchWordsDataStructure {

    private final TrieNode root;

    public AddAndSearchWordsDataStructure() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode current = this.root;
        for (char c: word.toCharArray()) {
           if (!current.nextNode.containsKey(c)) {
               current.nextNode.put(c, new TrieNode(c));
           }
           current = current.nextNode.get(c);
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        return searchRecur(word, this.root);
    }

    public boolean searchRecur(String word, TrieNode currentNode) {
        for (int i = 0; i < word.length(); i++) {
            final char c = word.charAt(i);
            if (!currentNode.nextNode.containsKey(c)) {
                if (c == '.') {
                    for (char nextChar: currentNode.nextNode.keySet()) {
                        if (searchRecur(word.substring(i + 1), currentNode.nextNode.get(nextChar))) {
                            return true;
                        }
                    }
                    return false;
                } else{
                    return false;
                }
            } else {
                currentNode = currentNode.nextNode.get(c);
            }
        }
        return currentNode.isWord;
    }

    static class TrieNode {
        Character word;
        HashMap<Character, TrieNode> nextNode;
        Boolean isWord = false;

        public TrieNode(Character c) {
            word = c;
            nextNode = new HashMap<>();
        }

        public TrieNode() {
            nextNode = new HashMap<>();
        }
    }

}
