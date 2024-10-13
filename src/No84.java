import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/10/12 11:35
 */
public class No84 {
    public static void main(String[] args) {
        int i = new Solution84().largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0});
        System.out.println(i);
    }
}

class Solution84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] > heights[i]) {
                Integer pop = stack.pop();
                if (!stack.isEmpty())
                    max = Math.max((i - stack.peek() - 1) * heights[pop], max);
                if (stack.isEmpty())
                    max = Math.max(i * heights[pop], max);
            }
            stack.push(i);
        }
        while (!stack.isEmpty() && heights[stack.peek()] > 0) {
            Integer pop = stack.pop();
            if (!stack.isEmpty())
                max = Math.max((heights.length - stack.peek() - 1) * heights[pop], max);
            if (stack.isEmpty())
                max = Math.max((heights.length) * heights[pop], max);
        }
        return max;
    }
}