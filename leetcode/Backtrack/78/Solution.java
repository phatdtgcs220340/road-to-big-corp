import java.util.ArrayList;
import java.util.List;

/**
 * 78: Subset
 * Difficulty : Medium
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, result, new ArrayList<>(), nums);
        return result;
    }

    public void backtrack(int start, List<List<Integer>> result, List<Integer> init, int[] nums) {
        result.add(new ArrayList<>(init));

        for (int i = start; i < nums.length; i++) {
            init.add(nums[i]);
            backtrack(i + 1, result, init, nums);
            init.remove(init.size() - 1);
        }

    }

    public static void main(String[] args) {

    }
}
