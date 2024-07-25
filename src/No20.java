import java.util.ArrayDeque;
import java.util.Locale;

import java.util.Stack;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/24
 */
public class No20 {
    public static void main(String[] args) {
        Solution20 solution20 = new Solution20();
        String s = "]";
        boolean valid = solution20.isValid(s);
        System.out.println(valid);
    }
}

class Solution20 {
    public boolean isValid(String s) {
        char[] charArray = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : charArray) {
            if (c == '}')
                if (!stack.isEmpty()&&stack.getLast() == '{') {
                    stack.pop();
                    continue;
                }
            if (c == ']')
                if (!stack.isEmpty()&&stack.getLast() == '[') {
                    stack.pop();
                    continue;

                }
            if (c == ')')
                if (!stack.isEmpty()&&stack.getLast() == '(') {
                    stack.pop();
                    continue;
                }
            stack.push(c);
        }
        return stack.isEmpty();
    }
}