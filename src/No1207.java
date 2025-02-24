import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Author daydream
 * Description
 * Date 2025/2/15 16:53
 */
public class No1207 {
}

class Solution1207_1 {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int value = entry.getValue();
            if (set.contains(value))
                return false;
            set.add(value);
        }
        return true;
    }
}

class Solution1207_2 {
    public boolean uniqueOccurrences(int[] arr) {
        int[] map = new int[2001];
        boolean[] set = new boolean[1000];
        for (int i : arr) {
            map[i + 1000]++;
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i] > 0) {
                if (!set[map[i]]) {
                    set[map[i]] = true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}