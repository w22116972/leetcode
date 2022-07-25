package design;

import java.util.HashMap;

public class FileSystem {

    private TrieNode root;

    public FileSystem() {
        this.root = new TrieNode(-1);
    }

    public boolean createPath(String path, int value) {
        if (path.length() <= 1 || path.charAt(0) != '/') {
            return false;
        }
        TrieNode current = this.root;
        final String[] paths = path.substring(1).split("/");
        int i = 0;
        while (i < paths.length) {
            final String directory = paths[i];
            if (i == paths.length - 1 && !current.nextDirectory.containsKey(directory)) {
                current.nextDirectory.put(directory, new TrieNode(value));
            } else if (i != paths.length - 1 && current.nextDirectory.containsKey(directory)) {
                current = current.nextDirectory.get(directory);
            } else {
                return false;
            }
            i++;
        }
        return true;
    }

    public int get(String path) {
        if (path.length() <= 1 || path.charAt(0) != '/') {
            return -1;
        }
        TrieNode current = this.root;

        final String[] paths = path.substring(1).split("/");
        int i = 0;
        while (i < paths.length) {
            final String directory = paths[i];
            if (i == paths.length - 1 && current.nextDirectory.containsKey(directory)) {
                return current.nextDirectory.get(directory).value;
            } else if (i != paths.length - 1 && current.nextDirectory.containsKey(directory)) {
                current = current.nextDirectory.get(directory);
            } else {
                return -1;
            }
            i++;
        }
        return -1;
    }

    static class TrieNode {
        int value;
        HashMap<String, TrieNode> nextDirectory = new HashMap<>();

        public TrieNode(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        String s = "a";
        final String[] split = s.split("/");
        System.out.println("split.length = " + split.length);
        System.out.println("split[0] = " + split[0]);
    }
}
