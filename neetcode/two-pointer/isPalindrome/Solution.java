public class Solution {
    public static boolean isPalindrome(String s) {
        String temp = s.toLowerCase().stripTrailing();
        int mid = (int) temp.length() / 2;

        for (int p1 = 0; p1 < mid; p1++) {
            int p2 = temp.length() - 1 - p1;
            if (temp.charAt(p1) != temp.charAt(p2)) 
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(args[0])); 
    } 
}
