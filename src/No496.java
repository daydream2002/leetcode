import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Author daydream
 * Description 496. 下一个更大元素 I
 * Date 2024/12/30 10:49
 */
public class No496 {
}
class Solution496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {
                int index = stack.pop();
                if (map.containsKey(nums2[index]))
                    res[map.get(nums2[index])] = nums2[i];
            }
            stack.push(i);
        }
        return res;
    }
}