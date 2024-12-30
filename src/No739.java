import java.util.Arrays;
import java.util.Stack;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/29
 */
public class No739 {
    public static void main(String[] args) {
        Solution739 solution739 = new Solution739();
        int[] ints = solution739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});
        System.out.println(Arrays.toString(ints));
    }
}

//递减单调栈
class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}