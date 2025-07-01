import java.util.ArrayList;
import java.util.List;

/**
 * 22 : Generate parenthese
 * Difficulty: Medium
 */
public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        recurse(0, 0, n, "", result);
        return result;
    }

    public void recurse(int open, int close, int n, String init, List<String> result) {
        if (init.length() == 2 * n) {
            result.add(new String(init));
            return;
        }
        if (open < n)
            recurse(open + 1, close, n, init + '(', result);
        if (close < open)
            recurse(open, close + 1, n, init + ')', result);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(10).stream().count());
    }
}
