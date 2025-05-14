package IsSubsequence;

/**
 * Is Subsequence solution 
 * Difficulty : Easy 
 * Type : Dynamic Programming
 */
public class Solution {
    boolean isSubsequence(String s, String t) {
        if (t.equals("") && s.equals("")) return true;
        if (s.equals("")) return s.equals("") && !t.equals("");
        char[] sArr = s.toCharArray();
        int index = 0;
        for (char c : t.toCharArray()) {
            if (index == s.length()) break;
            if (c == sArr[index])
                index++;
            
        }
        return index == s.length();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSubsequence(args[0], args[1]));
    }
}
