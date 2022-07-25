package stack;

import java.util.*;
import java.util.stream.Collectors;

public class SumOfSubarrayMinimums {
    public int sumSubarrayMins(int[] arr) {
        Stack<Integer> prevLessStack = new Stack<>();
        Stack<Integer> nextLessStack = new Stack<>();

        List<Integer> distanceToPrevLess = new ArrayList<>(arr.length);
        List<Integer> distanceToNextLess = new ArrayList<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
//            while (!prevLessStack.isEmpty() && )
        }

        int ans = 0;
        int mod = 1000000007;
        for(int i = 0; i < arr.length; i++) {
            ans = (ans + arr[i] * distanceToPrevLess.get(i) * distanceToNextLess.get(i)) % mod;
        }
        return ans;
    }


}
