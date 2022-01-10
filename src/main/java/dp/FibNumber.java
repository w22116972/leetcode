package dp;

import java.util.HashMap;
import java.util.Map;

public class FibNumber {
    public int fib(int n) {

        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fib(n-1) + fib(n-2);
        }

    }

    public int fibWithTable(int n) {
        Map<Integer, Integer> table = new HashMap<>();
        table.put(0, 0);
        table.put(1, 1);
        table.put(2, 1);
        return recur(n, table);
    }

    public int recur(int n, Map<Integer, Integer> table) {
        if (!table.containsKey(n)) {
            table.put(n, recur(n-1, table) + recur(n-2, table));
        }
        return table.get(n);
    }
}
