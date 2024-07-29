import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
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
        int[] res = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int index = -1;
            while (true) {
                if (stack.isEmpty() || temperatures[stack.peek()] >= temperatures[i]) {
                    stack.push(i);
                    break;
                } else {
                    index = stack.pop();
                    if (index >= 0)
                        res[index] = i - index;
                }
            }

        }
        return res;
    }
}
