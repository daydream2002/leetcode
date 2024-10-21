/**
 * Author daydream
 * Description
 * Date 2024/10/21 21:07
 */
public class No24 {
    public static void main(String[] args) {
        ListNode listNode = ListNode.init(new int[]{1, 2, 3, 4, 5,6});
        ListNode res = new Solution24Two().swapPairs(listNode);
        ListNode.print(res);
    }
}

class Solution24One {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode listNode = swapPairs(head.next.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = listNode;
        return temp;
    }
}

class Solution24Two {
    public ListNode swapPairs(ListNode head) {
        ListNode h = new ListNode();
        h.next = head;
        ListNode p, q, prev = h;
        while (prev.next != null && prev.next.next != null) {
            p = prev.next;
            q = p.next;
            p.next = q.next;
            q.next = p;
            prev.next = q;
            prev = q.next;
        }
        return h.next;
    }
}