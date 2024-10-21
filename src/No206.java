/**
 * Author daydream
 * Description
 * Date 2024/10/21 20:13
 */
public class No206 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.init(new int[]{1, 2, 3});
        ListNode listNode1 = new Solution206Three().reverseList(listNode);
        ListNode.print(listNode1);
    }
}

class Solution206One {
    public ListNode reverseList(ListNode head) {
        ListNode h = new ListNode();
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            p.next = h.next;
            h.next = p;
            p = q;
        }
        return h.next;
    }
}

class Solution206Two {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, cur = head;
        while (cur != null) {
            ListNode next;
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}

class Solution206Three {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode listNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }
}