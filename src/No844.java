import java.util.Objects;
import java.util.Stack;

public class No844 {
    public static void main(String[] args) {
        boolean b = new Solution844().backspaceCompare("y#fo##f", "y#f#o##f");
        System.out.println(b);
    }
}

class Solution844 {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !stack1.isEmpty()) 
                stack1.pop();
            else if (s.charAt(i) != '#')
                stack1.push(s.charAt(i));
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#' && !stack2.isEmpty())
                stack2.pop();
            else if (s.charAt(i) != '#')
                stack2.push(t.charAt(i));
        }
        return stack1.toString().equals(stack2.toString());
    }
}