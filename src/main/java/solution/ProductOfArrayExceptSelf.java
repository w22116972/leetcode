package solution;

import java.util.ArrayList;
import java.util.List;

// 這題算腦筋急轉彎
public class ProductOfArrayExceptSelf {

    // array = [a, b, c, d]
    // Prefix result = product from first to last
    // = [a, a * b, a * b * c, a * b * c * d]

    // Postfix result = product from last to first
    // = [a * b * c * d, b * c * d,  c * d, d]

    // Result = if i -> prefix[i - 1] * postfix[i + 1]
    // if i -1 < 0: return 1
    // if i + 1 >= n: return 1
    public int[] productExceptSelf(int[] nums) {

        int[] prefix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefix[i] = nums[i];
            } else {
                prefix[i] = prefix[i - 1] * nums[i];
            }
        }

        int[] postfix = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfix[i] = nums[i];
            } else {
                postfix[i] = postfix[i + 1] * nums[i];
            }
        }

        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 < 0) {
                result[i] = 1 * postfix[i + 1];
            } else if (i + 1 > nums.length - 1) {
                result[i] = prefix[i - 1] * 1;
            } else {
                result[i] = prefix[i - 1] * postfix[i + 1];
            }

        }
        return result;
    }
}
