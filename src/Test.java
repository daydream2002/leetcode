import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {
        int i = new Solution().evalRPN(new String[]{"4", "13", "5", "/", "+"});
        System.out.println(i);
    }
}

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        HashSet<String> set = new HashSet<>();
        set.add("+");
        set.add("-");
        set.add("*");
        set.add("/");
        for (String token : tokens) {
            if (set.contains(token)) {
                Integer r = stack.pop();
                Integer l = stack.pop();
                switch (token) {
                    case "+" -> stack.push(l + r);
                    case "-" -> stack.push(l - r);
                    case "*" -> stack.push(l * r);
                    case "/" -> stack.push(l / r);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}