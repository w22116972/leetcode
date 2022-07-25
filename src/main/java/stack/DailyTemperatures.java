package stack;

import java.util.LinkedList;

public class DailyTemperatures {
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
