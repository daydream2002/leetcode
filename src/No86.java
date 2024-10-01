/**
 * @author wjh
 * @date 2024/10/1 11:10
 */
public class No86 {
    public static void main(String[] args) {

    }
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        ListNode large = new ListNode();
        ListNode small = new ListNode();
        ListNode p = head, l = large, s = small;
        while (p != null) {
            if (p.val < x) {
                s.next = p;
                s = s.next;
                p = p.next;
                s.next = null;
            } else {
                l.next = p;
                l = l.next;
                p = p.next;
                l.next = null;
            }
        }
        s.next = large.next;
        return small.next;
    }
}