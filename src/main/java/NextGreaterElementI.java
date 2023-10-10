import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
    //

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // use nums2 to build monotonic decreasing stack
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> mapNums2ToNextGreaterNum = new HashMap<>();

        // use monotonic decreasing stack to ensure we can handle next greater element
        for (int n2: nums2) {
            while (!stack.isEmpty() && stack.peek() < n2)
                mapNums2ToNextGreaterNum.put(stack.pop(), n2); // Remember the next greater element for num
            // Push current number onto stack
            stack.push(n2);
        }

        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = mapNums2ToNextGreaterNum.getOrDefault(nums1[i], -1);
        }
        return result;
    }
}
