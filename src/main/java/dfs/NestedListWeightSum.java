package dfs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return dfs(nestedList, 1);
    }

    private int dfs(List<NestedInteger> list, int depth) {
        int total = 0;
        for (NestedInteger n: list) {
            if (n.isInteger()) {
                total += n.getInteger() * depth;
            } else {
                total += dfs(n.getList(), depth + 1);
            }
        }
        return total;
    }

    public int depthSumWithQueue(List<NestedInteger> nestedList) {
        Queue<NestedInteger> queue = new LinkedList<>();
        queue.addAll(nestedList);

        int depth = 1;
        int total = 0;
        while (!queue.isEmpty()) {
            final int size = queue.size();
            for (int i = 0; i < size; i++) {
                NestedInteger n = queue.poll();
                if (n.isInteger()) {
                    total += n.getInteger() * depth;
                } else {
                    queue.addAll(n.getList());
                }
            }
            depth++;
        }
        return total;
    }

    interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              boolean isInteger();

             // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
             Integer getInteger();

              // Set this NestedInteger to hold a single integer.
              void setInteger(int value);
              // Set this NestedInteger to hold a nested list and adds a nested integer to it.
              void add(NestedInteger ni);

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              List<NestedInteger> getList();
    }
}
