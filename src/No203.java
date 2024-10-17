/**
 * Author daydream
 * Description
 * Date 2024/10/17 20:16
 */
public class No203 {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.init(new int[]{6, 6});
        ListNode listNode = new Solution203Two().removeElements(listNode1, 6);
        ListNode.print(listNode);
    }
}

class Solution203One {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode h = new ListNode(), p;
        h.next = head;
        p = h;
        while (p.next != null) {
            if (p.next.val == val)
                p.next = p.next.next;
            else
                p = p.next;
        }
        return h.next;
    }
}

//递归
class Solution203Two {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
}