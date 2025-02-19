import java.util.*;

public class No1002 {
    public static void main(String[] args) {
        Solution1002 solution = new Solution1002();
        String[] words = {"bella", "label", "roller"};
        System.out.println(solution.commonChars(words));
    }
}

class Solution1002 {
    public List<String> commonChars(String[] words) {
        int[] map = new int[26];

        List<String> res = new ArrayList<>();
        for (int i = 0; i < words[0].length(); i++) {
            map[words[0].charAt(i) - 'a']++;
        }
        for (int i = 1; i < words.length; i++) {
            int[] otherMap = new int[26];
            for (int j = 0; j < words[i].length(); j++) {
                otherMap[words[i].charAt(j) - 'a']++;
            }
            for (int k = 0; k < 26; k++) {
                map[k] = Math.min(map[k], otherMap[k]);
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                for (int j = 0; j < map[i]; j++) {
                    res.add(String.valueOf((char) (i + 'a')));
                }
            }
        }
        return res;
    }
}