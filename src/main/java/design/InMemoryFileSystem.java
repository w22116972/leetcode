package design;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class InMemoryFileSystem {

    private TrieNode root;

    public InMemoryFileSystem() {
        this.root = new TrieNode(null);
    }

    public List<String> ls(String path) {
        TrieNode current = this.root;
        if (Objects.equals(path, "/")) {
            return current.nextDirectory.keySet().stream().sorted().collect(Collectors.toList());
        }

        var paths = path.substring(1).split("/");

        for (String s: paths) {
            current = current.nextDirectory.get(s);
        }

        if (current == null) {
            return List.of();
        } else {
            final LinkedList<String> result = new LinkedList<>();
            if (current.isFile) {
                result.add(current.name);
            }
            result.addAll(current.nextDirectory.keySet());
            return result.stream().sorted().collect(Collectors.toList());
        }
    }

    public void mkdir(String path) {
        TrieNode current = this.root;
        for (String directoryName: path.substring(1).split("/")) {
            if (!current.nextDirectory.containsKey(directoryName)) {
                current.nextDirectory.put(directoryName, new TrieNode(directoryName));
            }
            current = current.nextDirectory.get(directoryName);
        }
    }

    public void addContentToFile(String filePath, String content) {
        TrieNode current = this.root;
        for (String directoryName: filePath.substring(1).split("/")) {
            if (!current.nextDirectory.containsKey(directoryName)) {
                current.nextDirectory.put(directoryName, new TrieNode(directoryName));
            }
            current = current.nextDirectory.get(directoryName);
        }
        current.isFile = true;
        current.content.append(content);

//        int i = 0;
//        final String[] paths = filePath.substring(1).split("/");
//        while (i < paths.length) {
//            if (i == paths.length - 1) {
//                current.content.append(content);
//            } else if (!current.nextDirectory.containsKey(paths[i])) {
//                current.nextDirectory.put(paths[i], new TrieNode());
//            }
//            current = current.nextDirectory.get(paths[i]);
//            i++;
//        }

//        for (String s: filePath.substring(1).split("/")) {
//            current = current.nextPath.get(s);
//        }
//        current.content.append(content);
    }

    public String readContentFromFile(String filePath) {
        TrieNode current = this.root;
        for (String directoryName: filePath.substring(1).split("/")) {
            if (!current.nextDirectory.containsKey(directoryName)) {
                current.nextDirectory.put(directoryName, new TrieNode(directoryName));
            }
            current = current.nextDirectory.get(directoryName);
        }
        return current.content.toString();

//        int i = 0;
//        final String[] paths = filePath.substring(1).split("/");
//        while (i < paths.length) {
//            if (i == paths.length - 1) {
//                return current.content.toString();
//            } else {
//                current = current.nextDirectory.get(paths[i]);
//            }
//            i++;
//        }
//        return "";
    }

    static class TrieNode {
        StringBuilder content = new StringBuilder();
        HashMap<String, TrieNode> nextDirectory = new HashMap<>();
        Boolean isFile = false;

        String name;

        public TrieNode(String name) {
            this.name = name;
        }
    }
}
