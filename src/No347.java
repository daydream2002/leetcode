import java.util.*;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/31
 */
public class No347 {
    public static void main(String[] args) {
        Solution347 solution347 = new Solution347();
        int[] ints = {1, 1, 1, 2, 2, 3};
        int[] ints1 = solution347.topKFrequent(ints,2);
        System.out.println(Arrays.toString(ints1));
    }
}

class Solution347 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else
                map.put(num, 1);
        }
        ArrayList<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }
}