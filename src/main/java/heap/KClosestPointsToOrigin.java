package heap;

import java.util.*;

public class KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
//        PriorityQueue<Point> minHeap = new PriorityQueue<>((p1, p2) -> Double.compare(p2.distance, p1.distance));
        PriorityQueue<Point> minHeap = new PriorityQueue<>(Comparator.comparingDouble(p -> p.distance));
        for (int[] point: points) {
            minHeap.add(new Point(point[0], point[1]));
        }

        final int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            final Point point = minHeap.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
    }

    static class Point {
        int x;
        int y;
        double distance;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
            this.distance = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        }

    }

    public static void main(String[] args) {
        final int[][] ints = new KClosestPointsToOrigin().kClosest(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        System.out.println(Arrays.deepToString(ints));
    }
}
