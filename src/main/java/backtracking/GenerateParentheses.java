package backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return List.of();
        }
        List<String> result = new LinkedList<>();
        StringBuilder track = new StringBuilder();
        backtrack(n, n, track, result);
        return result;
    }

    private void backtrack(int left, int right, StringBuilder track, List<String> result) {
        // invalid
        if (left < 0 || right < 0) {
            return;
        }
        // it's illegal that left parentheses are more than right
        if (left > right) {
            return;
        }

        if (left == 0 && right == 0) {
            result.add(track.toString());
            return;
        }

        track.append("(");
        backtrack(left - 1, right, track, result);
        track.deleteCharAt(track.length() - 1);

        track.append(")");
        backtrack(left, right - 1, track, result);
        track.deleteCharAt(track.length() - 1);
    }
}
