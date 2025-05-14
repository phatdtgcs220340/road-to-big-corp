package NthTribonacciNumber;

import java.util.Arrays;

/**
 * N-th Tribonacci Number solution 
 * Type : Dynamic Programming 
 * Difficult : Easy 
 * JDK version: JDK 17
 * Time complexity: O(n)
 * Space complexity: O(1)
 * {@summary} Sum and permutate the triple of nearest tribonacci number.
 */
public class Solution {
    public int tribonacci(int n) {
        int[] nearestTribo = new int[] { 0, 1, 1 };
        if (n <= 2 && n >= 0) {
            return nearestTribo[n];
        } else {
            int sum = 0;
            int index = 3;
            while (index <= n) {
                // Can uncomment this to see nearest tribo for each loop
                // Arrays.stream(nearestTribo).forEach(num -> System.out.print(num + " "));
                // System.out.println();
                sum = sumAndPermutateTribo(nearestTribo);
                index++;
            }
            return sum;
        }
    }

    private int sumAndPermutateTribo(int[] tribo) {
        int temp1 = tribo[1];
        int temp2 = tribo[2];
        
        int sum = tribo[0] + tribo[1] + tribo[2];
        tribo[2] = sum;
        tribo[1] = temp2;
        tribo[0] = temp1;
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.tribonacci(37));
    }
}
