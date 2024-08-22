package solution;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

    private PriorityQueue<Integer> maxHeapForSmallNumber;
    private PriorityQueue<Integer> minHeapForBigNumber;

    public FindMedianFromDataStream() {
        maxHeapForSmallNumber = new PriorityQueue<>(Comparator.reverseOrder());
        minHeapForBigNumber = new PriorityQueue<>();

    }

    public void addNum(int num) {
        if (maxHeapForSmallNumber.size() == 0) {
            maxHeapForSmallNumber.add(num);
        } else if (minHeapForBigNumber.size() == 0) {
            if (num < maxHeapForSmallNumber.peek()) {
                minHeapForBigNumber.add(maxHeapForSmallNumber.poll());
                maxHeapForSmallNumber.add(num);
            } else {
                minHeapForBigNumber.add(num);
            }
        } else {
            int small = maxHeapForSmallNumber.peek();
            int big = minHeapForBigNumber.peek();
            if (maxHeapForSmallNumber.size() == minHeapForBigNumber.size()) {
                if (small <= num && num <= big) {
                    maxHeapForSmallNumber.add(num);
                } else if (num < small) {
                    maxHeapForSmallNumber.add(num);
                } else if (big < num) {
                    maxHeapForSmallNumber.add(minHeapForBigNumber.poll());
                    minHeapForBigNumber.add(num);
                }
            } else {  // maxHeap size > minHeap size
                if (small <= num && num <= big) {
                    minHeapForBigNumber.add(num);
                } else if (num < small) {
                    minHeapForBigNumber.add(maxHeapForSmallNumber.poll());
                    maxHeapForSmallNumber.add(num);
                } else if (big < num) {
                    minHeapForBigNumber.add(num);
                }
            }
        }

    }

    public double findMedian() {
        if (maxHeapForSmallNumber.size() == 0 || minHeapForBigNumber.size() == 0) {
            return maxHeapForSmallNumber.size() == 0 ? minHeapForBigNumber.peek():maxHeapForSmallNumber.peek();
        } else if (maxHeapForSmallNumber.size() == minHeapForBigNumber.size()) {
            return (double)(maxHeapForSmallNumber.peek() + minHeapForBigNumber.peek()) / 2;
        } else {
            return maxHeapForSmallNumber.size() > minHeapForBigNumber.size() ? maxHeapForSmallNumber.peek() : minHeapForBigNumber.peek();
        }
    }

    public void print() {
        System.out.println(Arrays.toString(maxHeapForSmallNumber.toArray()) + ", " + Arrays.toString(minHeapForBigNumber.toArray()));
    }

    public static void main(String[] args) {
        final FindMedianFromDataStream medianFinder = new FindMedianFromDataStream();
        medianFinder.addNum(12);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(13);
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(11);
        medianFinder.print();
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        medianFinder.addNum(5);
        medianFinder.print();
        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
        //  [12,11,12,11.5,11,11.50000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,11.00000,null,10.50000,null,10.00000,null,10.50000,null,10.00000]

//        System.out.println("medianFinder.findMedian() = " + medianFinder.findMedian());
//        medianFinder.print();
    }
}
