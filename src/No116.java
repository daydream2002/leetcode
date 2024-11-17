import java.util.LinkedList;
import java.util.Queue;

/**
 * Author daydream
 * Description
 * Date 2024/11/17 10:41
 */
class No116 {
    public static void main(String[] args) {

    }
}

class Solution1116 {
    public Node116 connect(Node116 root) {
        Queue<Node116> queue = new LinkedList<>();
        if (root != null)
            queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node116 poll = queue.poll();
                if (i==size-1) {
                    poll.next = null;
                } else {
                    poll.next = queue.peek();
                }
                if (poll.left != null)
                    queue.offer(poll.left);
                if (poll.right != null)
                    queue.offer(poll.right);
            }
        }
        return root;
    }
}

// Definition for a Node.
class Node116 {
    public int val;
    public Node116 left;
    public Node116 right;
    public Node116 next;

    public Node116() {
    }

    public Node116(int _val) {
        val = _val;
    }

    public Node116(int _val, Node116 _left, Node116 _right, Node116 _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
