import java.util.Stack;

/**
 * Author daydream
 * Description
 * Date 2024/11/7 11:40
 */
public class No232 {
}

class MyQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
    }

    public int pop() {
        if (s2.empty())
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        return s2.pop();
    }

    public int peek() {
        if (s2.empty())
            while (!s1.empty()) {
                s2.push(s1.pop());
            }
        return s2.peek();
    }

    public boolean empty() {
        return s1.empty()&&s2.empty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */