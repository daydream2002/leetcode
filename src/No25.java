/**
 * @author wjh
 * @date 2024/10/7 14:06
 * 25. K 个一组翻转链表 困难
 */

public class No25 {
    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{1, 2, 3, 4, 5});
        ListNode.print(head);
        ListNode listNode = new Solution25().reverseKGroup(head, 2);
        ListNode.print(listNode);
    }
}

class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode pre, l, r, cur = h;
        while (cur != null) {
            pre = cur;
            for (int i = 0; i < k; i++) {
                cur = cur.next;
                if (cur == null)
                    break;
            }
            if (cur == null)
                break;
            ListNode temp = cur.next;
            l = pre.next;
            r = cur;
            r.next = null;
            reverse(l);
            pre.next = r;
            l.next = temp;
            cur = l;
        }
        return h.next;
    }

    public void reverse(ListNode head) {
        ListNode pre = null, cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }
}