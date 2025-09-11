package leetcode;

public class Q136_SingleNumber {
    public int singleNumber(int[] nums) {
        // use XOR
        // 0 xor a = a
        // a xor a = 0
        int result = 0;
        for (int i: nums) {
            result ^= i;
        }
        return result;
    }
}
