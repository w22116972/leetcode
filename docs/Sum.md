# Sum

The format of problems is as `x + y + ... = 0`


#### Two Sum

For `x + y = 0`, we can rewrite it as `y = -x`. So we can use a hash table to store the value of `x` and check if `-x` exists in the hash table.

```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum leetcode");
}
```

#### Three Sum


#### Four Sum


#### N Sum







---

#twopointers

