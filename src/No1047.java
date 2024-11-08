import java.util.Stack;

/**
 * Author daydream
 * Description 删除字符串中的所有相邻重复项
 * Date 2024/11/8 11:08
 */
public class No1047 {
    public static void main(String[] args) {
        String s = new Solution1047().removeDuplicates("abbaca");
        System.out.println(s);
    }
}

class Solution1047 {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        for (char c : charArray) {
            if (!stack.isEmpty() && stack.peek() == c) {
                    stack.pop();
            } else {
                stack.push(c);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}