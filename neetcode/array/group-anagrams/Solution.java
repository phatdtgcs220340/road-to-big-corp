import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Integer, String> mapSortedStrings = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            mapSortedStrings.put(i, sortedStr);
        }

        Set<Integer> addedIndex = new HashSet<>();
        List<List<Integer>> groupedAnagramsIndex = new ArrayList<>();

        for (int i = 0; i < strs.length - 1; i++) {
            if (addedIndex.contains(i))
                continue;
            List<Integer> groupedAnagramIndex = new ArrayList<>();
            groupedAnagramIndex.add(i);
            addedIndex.add(i);
            for (int j = i + 1; j < strs.length; j++) {
                if (addedIndex.contains(j))
                    continue;
                if (mapSortedStrings.get(i).equals(mapSortedStrings.get(j))) {
                    groupedAnagramIndex.add(j);
                    addedIndex.add(j);
                }
            }
            groupedAnagramsIndex.add(groupedAnagramIndex);
        }

        if (!addedIndex.contains(strs.length - 1))
            groupedAnagramsIndex.add(List.of(strs.length - 1));

        return groupedAnagramsIndex.stream()
                .map(g -> g.stream()
                        .map(i -> strs[i])
                        .toList())
                .toList();
    }

    public static void main(String[] args) {

    }
}
