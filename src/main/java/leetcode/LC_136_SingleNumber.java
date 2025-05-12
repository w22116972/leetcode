package leetcode;

public class LC_136_SingleNumber {
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
