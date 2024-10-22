/**
 * Author daydream
 * Description
 * Date 2024/10/22 17:14
 */
public class No19 {
    public static void main(String[] args) {

    }
}

class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode p = h, q = h;
        for (int i = 0; i < n; i++) {
            p = p.next;
            if (p == null) {
                return null;
            }
        }
        while (p.next != null) {
            p = p.next;
            q = q.next;
        }
        q.next = q.next.next;
        return h.next;
    }
}