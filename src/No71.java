import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/9/27 14:53
 */
public class No71 {
    public static void main(String[] args) {
        String s = new Solution71().simplifyPath("/home/user/Documents/../Pictures");
    }
}

class Solution71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/+");
        StringBuilder res = new StringBuilder();
        System.out.println(Arrays.toString(split));
        Stack<String> stack = new Stack<>();
        for (String s : split) {
            if (!(Objects.equals(s, "") || s.equals(".")))
                stack.push(s);
        }
        System.out.println(stack);
        while (!stack.isEmpty()) {
            if (stack.peek().equals("."))
                stack.pop();
            else if (stack.peek().equals("..")) {
                stack.pop();
                int count = 1;
                while (count != 0) {
                    if (!stack.isEmpty() && stack.peek().equals(".."))
                        count = count + 2;
                    if (!stack.isEmpty()) {
                        stack.pop();
                        count--;
                    } else {
                        break;
                    }
                }
            } else {
                res.insert(0, stack.pop());
                res.insert(0, "/");
            }
        }
        if (res.isEmpty())
            res.append("/");
        System.out.println(res);
        return res.toString();
    }
}