import java.util.ArrayList;
import java.util.HashSet;
import java.util.function.ToIntFunction;

/**
 * Author daydream
 * Description
 * Date 2024/10/24 16:47
 */
public class No349 {
}

class Solution349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i))
                res.add(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}