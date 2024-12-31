import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/12/18 20:25
 */
public class Test {
    public static void main(String[] args) {
        int i = new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        System.out.println(i);
    }
}

class Solution {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int index = stack.pop();
                if (!stack.isEmpty())
                    res = res + (i - stack.peek() - 1) * (Math.min(height[i], height[stack.peek()]) - height[index]);
            }
            stack.push(i);
        }
        return res;
    }
}