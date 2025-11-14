import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];

        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Set<Integer> sortedSet = frequencyMap.keySet();

        for (int i = 0; i < k; i++) {
            int max = sortedSet.iterator().next(); 

            for (Integer num : sortedSet) {
                max = frequencyMap.get(num) > frequencyMap.get(max) ? num : max;
            }

            result[i] = max;
            sortedSet.remove(max);
        }

        return result;
    }
}
