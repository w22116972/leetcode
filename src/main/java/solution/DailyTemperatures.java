package solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

public class DailyTemperatures {
    public int[] sol(int[] temperatures) {
        final int[] result = new int[temperatures.length];
        // If there is no future day for which this is possible, keep answer[i] == 0
        Arrays.fill(result, 0);
        // A stack to store the indices of temperatures that are waiting for the next occurrence of a higher temperature.
        // Use monotonic decreasing stack pattern to handle when a higher temperature appears at index i
        final Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // When a higher temperature appears at index i
            while (!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                final int previousTempIndex = stack.pop();
                result[previousTempIndex] = i - previousTempIndex;
            }
            // Add index of next higher temp to stack
            stack.add(i);
        }
        return result;
    }

    // Use extra data structure
    public int[] dailyTemperatures(int[] temperatures) {
        final LinkedList<Data> stack = new LinkedList<>();
        final int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            int temp = temperatures[i];
            while (!stack.isEmpty() && temp > stack.getLast().temp) {
                final Data popData = stack.removeLast();
                result[popData.index] = i - popData.index;
            }
            stack.addLast(new Data(i, temp));
        }
        while (!stack.isEmpty()) {
            result[stack.poll().index] = 0;
        }
        return result;
    }


    static class Data {
        Integer index;
        Integer temp;

        public Data(Integer index, Integer temp) {
            this.index = index;
            this.temp = temp;
        }
    }
}
