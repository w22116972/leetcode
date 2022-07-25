package slidingwindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class SlidingWindowMaximum {

    public int[] sol2(int[] nums, int k) {
        final LinkedList<Integer> result = new LinkedList<>();
        // Window maximum will be at getFirst
        final LinkedList<Integer> deque = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            if (deque.isEmpty() || nums[i] <= deque.getLast()) {
                deque.addLast(nums[i]);
            } else {
                while (!deque.isEmpty() && nums[i] > deque.getLast()) {
                    deque.removeLast();
                }
                deque.addLast(nums[i]);
            }
        }
        int tail = k - 1;
        int head = 0;
        while (tail < nums.length) {
            result.add(deque.getFirst());
            // add tail
            tail++;
            if (tail >= nums.length) {
                break;
            }
            if (nums[tail] <= deque.getLast()) {
                deque.addLast(nums[tail]);
            } else {
                while (!deque.isEmpty() && nums[tail] > deque.getLast()) {
                    deque.removeLast();
                }
                deque.addLast(nums[tail]);
            }
            // remove head
            if (nums[head] == deque.getFirst()) {
                deque.removeFirst();
            }
            head++;
        }
        return result.stream().mapToInt(i->i).toArray();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        final LinkedList<Integer> result = new LinkedList<>();
        final LinkedList<Integer> maxIndexInDeque = new LinkedList<>();
        int tailIndex = 0;
        int headIndex = 0;
        while (tailIndex < nums.length) {
            // add tail
            while (!maxIndexInDeque.isEmpty() && nums[maxIndexInDeque.getLast()] < nums[tailIndex]) {
                maxIndexInDeque.removeLast();
            }
            maxIndexInDeque.addLast(tailIndex);

            // remove head
            if (headIndex > maxIndexInDeque.getFirst()) {
                maxIndexInDeque.removeFirst();
            }

            if (tailIndex + 1 >= k) {
                result.add(nums[maxIndexInDeque.getFirst()]);
                headIndex++;
            }
            tailIndex++;
        }
        return result.stream().mapToInt(i->i).toArray();
    }



    public static void main(String[] args) {
        final SlidingWindowMaximum sol = new SlidingWindowMaximum();
//        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
//        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1}, 1)));
//        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1, -1}, 1)));
//        System.out.println(Arrays.toString(sol.maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3))); // [3,3,2,5]

        System.out.println(Arrays.toString(sol.sol2(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(sol.sol2(new int[]{1}, 1)));
        System.out.println(Arrays.toString(sol.sol2(new int[]{1, -1}, 1)));
        System.out.println(Arrays.toString(sol.sol2(new int[]{1, 3, 1, 2, 0, 5}, 3))); // [3,3,2,5]

    }
}
