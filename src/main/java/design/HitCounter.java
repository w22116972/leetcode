package design;

import java.util.LinkedList;
import java.util.Queue;

public class HitCounter {

    private LinkedList<Hit> queue;

    public HitCounter() {
        queue = new LinkedList<>();
    }

    public void hit(int timestamp) {
        if (queue.isEmpty() || queue.peekLast().timestamp != timestamp) {
            queue.add(new Hit(timestamp));
        } else {
            queue.peekLast().frequency++;
        }

        // update queue
        while (!queue.isEmpty() && queue.peekLast().timestamp - queue.peekFirst().timestamp >= 300) {
            queue.pollFirst();
        }
    }

    public int getHits(int timestamp) {
        while (!queue.isEmpty() && timestamp - queue.peekFirst().timestamp >= 300) {
            queue.pollFirst();
        }

        int count = 0;
        return queue.stream().map(hit -> hit.frequency).reduce(Integer::sum).orElse(0);
    }

    static class Hit {
        int timestamp;
        int frequency = 1;

        public Hit(int timestamp) {
            this.timestamp = timestamp;
        }
    }
}
