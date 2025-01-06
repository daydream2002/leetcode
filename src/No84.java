import java.util.Stack;

/**
 * Author daydream
 * Description 84. 柱状图中最大的矩形
 * Date 2024/10/12 11:35
 */
public class No84 {
    public static void main(String[] args) {
        int i = new Solution84One().largestRectangleArea(new int[]{3, 6, 5, 7, 4, 8, 1, 0});
        System.out.println(i);
    }
}

//单调栈，核心思想找到左右边界（比当前高度低的）
class Solution84One {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        int[] heightsNew = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            heightsNew[i + 1] = heights[i];
        }
        for (int i = 0; i < heightsNew.length; i++) {
            while (!stack.isEmpty() && heightsNew[i] < heightsNew[stack.peek()]) {
                int index = stack.pop();
                max = Math.max(max, (i - stack.peek() - 1) * heightsNew[index]);
            }
            stack.push(i);
        }
        return max;
    }
}

//双指针
class Solution84Two {
    public int largestRectangleArea(int[] heights) {
        int[] left = new int[heights.length];
        int[] right = new int[heights.length];
        left[0] = -1;
        right[heights.length - 1] = heights.length;
        for (int i = 1; i < heights.length; i++) {
            int j = i - 1;
            while (j >= 0 && heights[j] >= heights[i])
                j = left[j];
            left[i] = j;
        }
        for (int i = heights.length - 2; i >= 0; i--) {
            int j = i + 1;
            while (j < heights.length && heights[j] >= heights[i])
                j = right[j];
            ;
            right[i] = j;
        }
        int res = 0;
        for (int i = 0; i < heights.length; i++) {
            res = Math.max(res, heights[i] * (right[i] - left[i] - 1));
        }
        return res;
    }
}