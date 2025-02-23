import java.util.Deque;
import java.util.LinkedList;

public class No143 {
    public static void main(String[] args) {
        ListNode init = ListNode.init(new int[]{1, 2, 3, 4, 5});
        new Solution143Two().reorderList(init);
        ListNode.print(init);
    }
}

class Solution143One {
    public void reorderList(ListNode head) {
        ListNode p = head, q = head, pre = head;
        while (p != null && p.next != null) {
            pre = q;
            p = p.next.next;
            q = q.next;
        }
        if (p != null) {
            pre = q;
        }
        p = pre.next;
        pre.next = null;
        q = head;
        while (p != null) {
            pre = p;
            p = p.next;
            pre.next = q.next;
            q.next = pre;
            q = pre.next;
        }
    }
}

class Solution143Two {
    public void reorderList(ListNode head) {
        Deque<ListNode> deque = new LinkedList<>();
        ListNode p = head.next;
        while (p != null) {
            deque.addLast(p);
            p = p.next;
        }
        ListNode cur = head;
        int count = 0;
        while (!deque.isEmpty()) {
            if (count % 2 == 0) {
                cur.next = deque.pollLast();
            } else {
                cur.next = deque.pollFirst();
            }
            cur = cur.next;
            count++;
        }
        cur.next = null;
    }
}