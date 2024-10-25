import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Author daydream
 * Description
 * Date 2024/10/25 10:49
 */
public class No454 {
    public static void main(String[] args) {
        int[] arr1 = {1, 2};
        int[] arr2 = {-2, -1};
        int[] arr3 = {-1, 2};
        int[] arr4 = {0, 2};
        int i = new Solution454Two().fourSumCount(arr1, arr2, arr3, arr4);
        System.out.println(i);
    }
}

class Solution454One {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int k : nums1) {
            map.put(k, map.getOrDefault(k, 0) + 1);
        }
        HashMap<Integer, Integer> map2 = new HashMap<>();
        for (int j : nums2) {
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int count = entry.getKey() + j;
                map2.put(count, map2.getOrDefault(count, 0) + map.getOrDefault(entry.getKey(), 0));
            }
        }
        HashMap<Integer, Integer> map3 = new HashMap<>();
        for (int i : nums3) {
            for (Map.Entry<Integer, Integer> entry : map2.entrySet()) {
                int count = entry.getKey() + i;
                map3.put(count, map3.getOrDefault(count, 0) + map2.getOrDefault(entry.getKey(), 0));
            }
        }
        HashMap<Integer, Integer> map4 = new HashMap<>();
        for (int i : nums4) {
            for (Map.Entry<Integer, Integer> entry : map3.entrySet()) {
                int count = entry.getKey() + i;
                map4.put(count, map4.getOrDefault(count, 0) + map3.getOrDefault(entry.getKey(), 0));
            }
        }
        return map4.getOrDefault(0, 0);
    }
}

class Solution454Two {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                map.put(i + j, map.getOrDefault(i+j, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int j : nums4) {
                res += map.getOrDefault(-i - j, 0);
            }
        }
        return res;
    }
}