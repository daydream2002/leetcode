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

//动态规划
class Solution42One {
    public int trap(int[] height) {
        int ans = 0;
        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];
        leftMax[0] = height[0];
        rightMax[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int max = Math.min(leftMax[i], rightMax[i]);
            ans = ans + max - height[i];
        }
        return ans;
    }
}

//单调栈
class Solution42Two {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (stack.isEmpty() || height[stack.peek()] > height[i]) {
                stack.push(i);
            } else {
                while (height[i] > height[stack.peek()]) {
                    Integer index = stack.pop();
                    if (stack.isEmpty())
                        break;
                    ans = ans + (i - stack.peek() - 1) * (Math.min(height[stack.peek()], height[i]) - height[index]);
                }
                stack.push(i);
            }
        }
        return ans;
    }
}

//双指针
class Solution42Three {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1, leftMax = 0, rightMax = 0, ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] < leftMax)
                    ans = ans + leftMax - height[left];
                else
                    leftMax = height[left];
                left++;
            } else {
                if (height[right] < rightMax)
                    ans = ans + rightMax - height[right];
                else
                    rightMax = height[right];
                right--;
            }
        }
        return ans;
    }
}