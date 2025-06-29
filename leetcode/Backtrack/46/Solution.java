import java.util.ArrayList;
import java.util.List;

/**
 * 46: Permutation
 * Difficulty: Medium
 */
public class Solution {
    public List<List<Integer>> permutate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), result);
        return result;

    }

    public void backtrack(int[] nums, List<Integer> init, List<List<Integer>> result) {
        // done
        if (init.size() == nums.length) {
            result.add(new ArrayList<>(init));
            printList(init);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            // cause 11 doesn't exist in constraints
            if (nums[i] != 11) {
                nums[i] = 11;
                init.add(temp);
                backtrack(nums, init, result);
                nums[i] = temp;
                init.removeLast();
            }
        }
        init = new ArrayList<>();
    }

    public static void printList(List<Integer> list) {
        System.out.println(String.join(", ", list.stream().map(e -> String.format("%d", e)).toList()));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.permutate(new int[]{ 1, -1, 0 });
    }
}
