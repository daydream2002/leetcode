import java.util.Stack;

/**
 * @author wjh
 * @date 2024/10/4 21:20
 */
//接雨水
public class No42 {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int trap = new Solution42Three().trap(arr);
        System.out.println(trap);
    }
}


//单调栈
class Solution42Two {
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

//双指针,修改为代码随想录的写法
class Solution42Three {
    public int trap(int[] height) {
        //定义两个数组记录下当前位置左边柱子的最高高度和右边柱子的最高高度
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        int res = 0;
        leftMax[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(leftMax[i], rightMax[i]) - height[i];
        }
        return res;
    }
}