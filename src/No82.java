/**
 * Author daydream
 * Description
 * Date 2024/9/29 10:29
 */
public class No82 {
    public static void main(String[] args) {
        ListNode h = new ListNode();
        ListNode p = h;
        int[] arr = {1, 1};
        for (int i = 0; i < arr.length; i++) {
            ListNode listNode = new ListNode(arr[i]);
            p.next = listNode;
            p = listNode;
        }
        p = h;
//        while (p != null) {
//            System.out.println(p.val);
//            p = p.next;
//        }
        new Solution82().deleteDuplicates(h.next);

    }
}


class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode p, q;
        ListNode h = new ListNode();
        h.next = head;
        p = h;
        while (p != null && p.next != null && p.next.next != null) {
            while (p.next != null && p.next.next != null && p.next.val == p.next.next.val) {
                q = p.next;
                while (q != null  && q.val == p.next.val) {
                    q = q.next;
                }
                p.next = q;
            }
            p = p.next;
        }
        return h.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}