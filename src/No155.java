import java.util.ArrayList;

/**
 * @Author daydream
 * @Description
 * @Date 2024/7/25
 */
public class No155 {
    public static void main(String[] args) {

    }
}

class MinStack {
    ArrayList<Integer> stack;
    ArrayList<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayList<>();
        minStack = new ArrayList<>();
        minStack.add(Integer.MAX_VALUE);
    }

    public void push(int val) {
        this.stack.add(val);
        minStack.add(Math.min(val, minStack.getLast()));
    }

    public void pop() {
        this.stack.removeLast();
        minStack.removeLast();
    }

    public int top() {
        return this.stack.getLast();
    }

    public int getMin() {
        return minStack.getLast();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */