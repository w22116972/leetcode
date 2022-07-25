package design;

import lombok.val;

import java.util.HashMap;

public class ImplementTrie {

    private final TrieNode root;

    public ImplementTrie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode current = this.root;
        for (char c: word.toCharArray()) {
            if (!current.nextNode.containsKey(c)) {
                return false;
            }
            current = current.nextNode.get(c);
        }
        return current.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode current = this.root;
        for (char c: prefix.toCharArray()) {
            if (!current.nextNode.containsKey(c)) {
                return false;
            }
            current = current.nextNode.get(c);
        }
        return true;
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

    public static void main(String[] args) {
        final val trie1 = new ImplementTrie();

        trie1.insert("a");
        trie1.insert("pa");
        System.out.println("trie1.search(\"p\") = " + trie1.search("p"));


    }
}
