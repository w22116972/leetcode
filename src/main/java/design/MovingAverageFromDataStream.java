package design;

import java.util.LinkedList;

public class MovingAverageFromDataStream {
    private LinkedList<Integer> queue;
    private final Integer maxSize;

    public MovingAverageFromDataStream(int size) {
        this.maxSize = size;
        this.queue = new LinkedList<>();
    }

    public double next(int val) {
        queue.add(val);
        if (queue.size() > maxSize) {
            queue.pollFirst();
        }
        return (double) queue.stream().reduce(Integer::sum).orElse(0) / queue.size();
    }
}
