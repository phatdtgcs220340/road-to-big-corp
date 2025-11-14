import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Sort an string that a letter cannot be duplicated contunieously in k times
 * Example: 
 * - Input s = "zzzaaabbb" k = 2 
 * - Output: zzaabbzab
 */
public class Solution {
    public String sort(String s, int k) {
        Map<Character, Integer> mapLetter = new HashMap<>(); 
        StringBuilder result = new StringBuilder("");

        // Get frequency of each letter in string to count later
        for (char c : s.toCharArray()) {
            mapLetter.put(c, mapLetter.getOrDefault(c, 0) + 1);
        }

        int countLetterZeroFrequency = 0;
        List<Character> sortedKeys = mapLetter.keySet().stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        while (countLetterZeroFrequency < sortedKeys.size()) {
            for (char c : sortedKeys) {
                int remains = mapLetter.get(c);

                for (int i = 0; remains > k ? i < k : i < remains; i++) {
                    result.append(c); 
                    remains--;
                } 

                mapLetter.put(c, remains);

                if (remains == 0) {
                    countLetterZeroFrequency++;
                }
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution(); 
        
        System.out.println(solution.sort(args[0], Integer.valueOf(args[1])));
    }
}
