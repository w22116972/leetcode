package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class SearchSuggestionsSystem {

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> result = new LinkedList<>();
        for (String product: products) {
            TrieNode current = trieTree.root;
            for (char c: product.toCharArray()) {
                if (!current.nextTrieNode.containsKey(c)) {
                    current.nextTrieNode.put(c, new TrieNode());
                }
                final TrieNode nextTrieNode = current.nextTrieNode.get(c);
                nextTrieNode.products.add(product);
                current = nextTrieNode;
            }
        }

        TrieNode current = trieTree.root;
        boolean isEnd = false;
        for (char s: searchWord.toCharArray()) {
            if (isEnd || !current.nextTrieNode.containsKey(s)) {
                result.add(List.of());
                isEnd = true;
            } else {
                final TrieNode nextTrieNode = current.nextTrieNode.get(s);
                result.add(nextTrieNode.products.stream().sorted().limit(3).collect(Collectors.toList()));
                current = nextTrieNode;
            }
        }
        return result;
    }

    private final TrieTree trieTree = new TrieTree();

    static class TrieTree {
        TrieNode root = new TrieNode();
    }

    static class TrieNode {
        List<String> products = new LinkedList<>();
        HashMap<Character, TrieNode> nextTrieNode = new HashMap<>();

    }

}
