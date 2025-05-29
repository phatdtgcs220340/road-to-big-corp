/*
 * Container With Most Water problem
 * Difficult: Medium
 * Time complexity : O(n)
 * Space complexity : O(1)
 * Solution: Two pointer in left and right most of the array
 */
public class Solution {
    public int maxArea(int[] height) {
        int p1 = 0;
        int p2 = height.length - 1;
        int max = 0;
        while (p1 != p2) {
            max = Math.max(max, Math.min(height[p1], height[p2]) * (p2 - p1));
            if (height[p1] < height[p2])
                p1++;
            else
                p2--;
        }

        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
        System.out.println(solution.maxArea(new int[] { 1, 1 }));
    }
}
