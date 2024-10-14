import java.util.Arrays;
import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/10/13 10:01
 */
public class No32 {
    public static void main(String[] args) {
        int i = new Solution32Two().longestValidParentheses("())");
        System.out.println(i);
    }
}

//动态规划
class Solution32One {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 1; i < charArray.length; i++) {
            if (charArray[i] == ')' && i - dp[i - 1] - 1 >= 0) {
                if (charArray[i - dp[i - 1] - 1] == '(') {
                    if (i - dp[i - 1] - 2 >= 0)
                        dp[i] = 2 + dp[i - 1] + dp[i - dp[i - 1] - 2];
                    else
                        dp[i] = 2 + dp[i - 1];
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}

//栈
class Solution32Two {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        char[] charArray = s.toCharArray();
        stack.push(-1);
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(')
                stack.push(i);
            else {
                stack.pop();
                if (stack.isEmpty())
                    stack.push(i);
                else
                    max = Math.max(max, i - stack.peek());
            }
        }
        return max;
    }
}

//技巧解题
class Solution32Three {
    public int longestValidParentheses(String s) {
        int l = 0, r = 0, max = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '(')
                l++;
            else
                r++;
            if (r > l) {
                r = 0;
                l = 0;
            }
            if (r == l) {
                max = Math.max(max, l);
            }
        }
        r = 0;
        l = 0;
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] == ')')
                r++;
            else
                l++;
            if (l > r) {
                r = 0;
                l = 0;
            }
            if (r == l) {
                max = Math.max(max, l);
            }
        }
        return max*2;
    }
}