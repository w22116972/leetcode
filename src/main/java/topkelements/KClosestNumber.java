package topkelements;

import java.util.*;

import static java.lang.Math.abs;

public class KClosestNumber {

    // Closest means minimal difference -> max heap
    // T = O(n log n + k log n + n log n) = O(n log n)
    public static List<Integer> bruteForce(List<Integer> arr, int k, int x) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, (n1, n2) -> abs(n2 - x) - abs(n1 - x));
        for (int i: arr) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        List<Integer> answer = new ArrayList<>(k);
        for (int i = 0; i < k; i++) {
            answer.add(maxHeap.poll());
        }
        answer.sort(Comparator.naturalOrder());
        return answer;
    }

    // T = O(logN + K ∗ logK)
    // since given array is sorted, we could use BST to find closest number -> T = O(k log k)
    public static List<Integer> binarySearchSol(int[] arr, int k, int x) {
        // 0. use min-heap for minimal of difference
        PriorityQueue<AbstractMap.SimpleImmutableEntry<Integer, Integer>> minHeap = new PriorityQueue<>();
        // 1. use BS to find possible "mid" number
        // if found, return index of that element
        // if not found, return - (Insertion index) - 1
        final int binarySearchIndex = Arrays.binarySearch(arr, x);
        final int closestIndex = binarySearchIndex > 0 ? binarySearchIndex: -(binarySearchIndex + 1);
        // 2. find k number before and after this mid number
        final int lowestIndex = Math.max(closestIndex - k, 0);
        final int highestIndex = Math.min(closestIndex + k, arr.length - 1);
        // 3. put those number into min-heap
        for (int i = lowestIndex; i < highestIndex; i++) {
            minHeap.add(new AbstractMap.SimpleImmutableEntry(Math.abs(arr[i] - x), i));
        }
        //
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++)
            result.add(arr[minHeap.poll().getValue()]);

        Collections.sort(result);
        return result;
    }

    // use Two Pointers to find K closest number
    // T = O(log n + k)
    public static List<Integer> twoPointersSol(int[] arr, int k, int x) {
        // 1. use BS to find possible "mid" number
        // if found, return index of that element
        // if not found, return - (Insertion index) - 1
        final int binarySearchIndex = Arrays.binarySearch(arr, x);

        final int closestIndex = binarySearchIndex > 0 ? binarySearchIndex: -(binarySearchIndex + 1);

        // since closestIndex could be arr.length, leftIndex will become arr.length
        int leftPointerIndex = closestIndex - 1;
        int rightPointerIndex = closestIndex;

        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (isBothPointersInRange(arr.length, leftPointerIndex, rightPointerIndex)) {
                final int leftPointerDifference = Math.abs(x - arr[leftPointerIndex]);
                final int rightPointerDifference = Math.abs(x - arr[rightPointerIndex]);

                if (leftPointerDifference <= rightPointerDifference) {
                    result.add(0, arr[leftPointerIndex]); // append to beginning
                    leftPointerIndex--;
                } else {
                    result.add(arr[rightPointerIndex]); // append to end
                    rightPointerIndex++;
                }
            } else if (isLeftPointerOutOfRange(arr.length, leftPointerIndex, rightPointerIndex)) {
                result.add(arr[rightPointerIndex]);
                rightPointerIndex++;
            } else if (isRightPointerOutOfRange(arr.length, leftPointerIndex, rightPointerIndex)) {
                try {
                    result.add(0, arr[leftPointerIndex]);
                } catch (ArrayIndexOutOfBoundsException e) {
                    System.out.println("binarySearchIndex = " + binarySearchIndex);
                    System.out.println("closestIndex = " + closestIndex);
                    System.out.println("leftPointerIndex = " + leftPointerIndex);
                    System.out.println("rightPointerIndex = " + rightPointerIndex);
                    e.printStackTrace();
                }
                leftPointerIndex--;
            } else if (isBothPointersOutOfRange(arr.length, leftPointerIndex, rightPointerIndex)) {
                break;
            }
        }
        return result;
    }

    public static Boolean isBothPointersInRange(int arrayLength, int leftPointerIndex, int rightPointerIndex) {
        return leftPointerIndex >= 0 && rightPointerIndex < arrayLength && leftPointerIndex < rightPointerIndex;
    }

    public static Boolean isLeftPointerOutOfRange(int arrayLength, int leftPointerIndex, int rightPointerIndex) {
        return leftPointerIndex < 0 && rightPointerIndex < arrayLength && leftPointerIndex < rightPointerIndex;
    }

    public static Boolean isRightPointerOutOfRange(int arrayLength, int leftPointerIndex, int rightPointerIndex) {
        return leftPointerIndex >= 0 && rightPointerIndex >= arrayLength && leftPointerIndex < rightPointerIndex;
    }

    public static Boolean isBothPointersOutOfRange(int arrayLength, int leftPointerIndex, int rightPointerIndex) {
        return (leftPointerIndex < 0 && rightPointerIndex >= arrayLength) || (leftPointerIndex >= rightPointerIndex);
    }

}
