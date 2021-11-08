package bfs;

import java.util.*;

public class OpenLock {
    public int openLock(String[] deadends, String target) {
        // `deadends` is array type, but we need ds that has .contains()
        // To avoid checking duplicate strings, we could use Set
        Set<String> deadLocks = new HashSet<>(Arrays.asList(deadends));
        // Use visited to avoid loop
        Set<String> visitedLocks = new HashSet<>();
        int step = 0;

        Queue<String> queue = new LinkedList<>();
        final String root = "0000";
        queue.offer(root);
        visitedLocks.add(root);

        while (!queue.isEmpty()) {
            final int numberOfNodesInThisLevel = queue.size();
            for (int i = 0; i < numberOfNodesInThisLevel; i++) {
                String currentLock = queue.poll();

                // if it reaches dead
                if (deadLocks.contains(currentLock)) {
                    continue;
                }
                if (Objects.equals(currentLock, target)) {
                    return step;
                }
                // put not yet traversal node to queue
                // there are 4 digits
                for (int digitIndex = 0; digitIndex < 4; digitIndex++) {
                    final String plusOneLock = plusOne(currentLock, digitIndex);
                    if (!visitedLocks.contains(plusOneLock)) {
                        queue.offer(plusOneLock);
                        visitedLocks.add(plusOneLock);
                    }
                    final String minusOneLock = minusOne(currentLock, digitIndex);
                    if (!visitedLocks.contains(minusOneLock)) {
                        queue.offer(minusOneLock);
                        visitedLocks.add(minusOneLock);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String plusOne(String s, int indexToBeChanged) {
        char[] chars = s.toCharArray();
        if (chars[indexToBeChanged] == '9') {
            chars[indexToBeChanged] = '0';
        } else {
            chars[indexToBeChanged] += 1;
        }
        return new String(chars);
    }

    public String minusOne(String s, int indexToBeChanged) {
        char[] chars = s.toCharArray();
        if (chars[indexToBeChanged] == '0') {
            chars[indexToBeChanged] = '9';
        } else {
            chars[indexToBeChanged] += 1;
        }
        return new String(chars);
    }
}
