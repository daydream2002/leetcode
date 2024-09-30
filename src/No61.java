import java.time.chrono.MinguoChronology;

/**
 * @author wjh
 * @date 2024/9/30 20:28
 */
public class No61 {
    public static void main(String[] args) {
        ListNode h = new ListNode();
        ListNode p = h;
        int[] arr = {1, 2, 3, 4, 5};
        for (int i = 0; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            p.next = listNode;
            p = listNode;
        }
        ListNode listNode = new Solution61().rotateRight(h.next, 0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }

    }
}

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        ListNode h = new ListNode();
        h.next = head;
        ListNode p = h, end, q;
        int count = 0;
        while (p.next != null) {
            p = p.next;
            count++;
        }
        end = p;
        if (k % count == 0)
            return head;
        k = count - k % count;
        p = h;
        while (k != 0) {
            p = p.next;
            k--;
        }
        q = p.next;
        p.next = null;
        end.next = h.next;
        h.next = q;
        return h.next;
    }
}
