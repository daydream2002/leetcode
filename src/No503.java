import java.util.Arrays;
import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/12/30 11:28
 */
public class No503 {
}

class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        for (int i = 0; i < nums.length * 2; i++) {
            while (!stack.isEmpty() && nums[i % nums.length] > nums[stack.peek()]) {
                int index = stack.pop();
                res[index] = nums[i % nums.length];
            }
            stack.push(i % nums.length);
        }
        return res;
    }
}