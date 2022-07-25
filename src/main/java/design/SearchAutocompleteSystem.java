package design;

import java.util.*;

public class SearchAutocompleteSystem {

//    private Word root = new Word(null);

    private final TrieNode root;
    private TrieNode currentInputNode;
    StringBuilder currentWord;

    public SearchAutocompleteSystem(String[] sentences, int[] times) {
        this.root = new TrieNode();
        this.currentInputNode = this.root;
        this.currentWord = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            addSentence(sentences[i], times[i]);
        }
    }

    public void addSentence(String sentence, int time) {
        TrieNode currentAddingNode = this.root;
        // To update each node along the chars
        final LinkedList<TrieNode> visitedNodes = new LinkedList<>();
        for (char c: sentence.toCharArray()) {
            if (currentAddingNode.nextNodes[c] == null) {
                currentAddingNode.nextNodes[c] = new TrieNode();
            }
            // go to next char
            currentAddingNode = currentAddingNode.nextNodes[c];
            visitedNodes.add(currentAddingNode);
        }
        // now here is bottom
        currentAddingNode.word = sentence;
        currentAddingNode.times += time;

        // update each node along the chars
        for (TrieNode node: visitedNodes) {
            node.updateHotNodes(currentAddingNode);
        }
    }

    public List<String> input(char c) {
        final LinkedList<String> result = new LinkedList<>();
        if (c == '#') {
            addSentence(currentWord.toString(), 1);
            // clear stringBuilder
            currentWord.setLength(0);
            // back to root
            currentInputNode = root;
            return result;
        }
        currentWord.append(c);

        // go to next level if current node is not null
        if (currentInputNode != null) {
            currentInputNode = currentInputNode.nextNodes[c];
        }
        if (currentInputNode == null) {
            return result;
        }

        // return current hot node
        for (TrieNode node: currentInputNode.hotNodes) {
            result.add(node.word);
        }
        return result;
    }

    static class TrieNode implements Comparable<TrieNode>  {
        TrieNode[] nextNodes = new TrieNode[128];

        String word = null; // null if not a word
        int times = 0;
        LinkedList<TrieNode> hotNodes = new LinkedList<>();

        @Override
        public int compareTo(TrieNode otherNode) {
            if (this.times == otherNode.times) {
                // sort nodes by lexicographical order
                return this.word.compareTo(otherNode.word);
            } else {
                // sort nodes by frequency in desc order
                return otherNode.times - this.times;
            }
        }

        public void updateHotNodes(TrieNode node) {
            if (!this.hotNodes.contains(node)) {
                this.hotNodes.add(node);
            }

            Collections.sort(hotNodes);

            if (hotNodes.size() > 3) {
                hotNodes.removeLast();
            }
        }
    }


    @Deprecated
    static class Word {
        String word;
        PriorityQueue<Sentence> topFrequentSentences = new PriorityQueue<>(
                Comparator.comparing(Sentence::getFrequency, Comparator.reverseOrder()));
        HashMap<Character, Word> nextWords = new HashMap<>();

        public Word(String word) {
            this.word = word;
        }
    }

    @Deprecated
    static class Sentence {
        Integer frequency;
        String sentence;
        public Integer getFrequency() {
            return this.frequency;
        }
    }

}
