import java.util.Stack;

/**
 * @author wjh
 * @date 2024/9/28 10:12
 */
public class No150 {
    public static void main(String[] args) {
        int i = new Solution150().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"});
        System.out.println(i);
    }
}

class Solution150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> num = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                Integer right = num.pop();
                Integer left = num.pop();
                switch (token) {
                    case "+" -> num.push(left + right);
                    case "-" -> num.push(left - right);
                    case "*" -> num.push(left * right);
                    case "/" -> num.push(left / right);
                }
            } else
                num.push(Integer.parseInt(token));
        }
        return num.peek();
    }
}