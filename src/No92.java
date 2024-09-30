import java.util.ArrayList;

/**
 * @author wjh
 * @date 2024/9/28 10:36
 */
public class No92 {
    public static void main(String[] args) {
        ListNode head = new ListNode();
        int[] ints = {1, 2};
        ListNode p = head;
        head.val = ints[0];
        for (int i = 1; i < ints.length; i++) {
            ListNode listNode = new ListNode(ints[i]);
            p.next = listNode;
            p = listNode;
        }
        ListNode listNode = new Solution92Two().reverseBetween(head, 1, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}


class Solution92One {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode p = head;
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode h = new ListNode();
        h.next = head;
        list.add(h);
        while (p != null) {
            list.add(p);
            p = p.next;
        }
        list.add(null);
        for (int i = right; i > left; i--) {
            list.get(i).next = list.get(i - 1);
        }
        list.get(left - 1).next = list.get(right);
        list.get(left).next = list.get(right + 1);
        return list.getFirst().next;
    }
}

//穿针引线
class Solution92Two {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode l1 = null, l2 = null, r1 = null, r2, p;
        ListNode h = new ListNode();
        h.next = head;
        p = h;
        for (int i = 0; i <= right; i++) {
            if (i == left - 1)
                l1 = p;
            if (i == right)
                r1 = p;
            p = p.next;
        }
        r2 = r1.next;
        l2 = l1.next;
        l1.next = null;
        r1.next = null;
        reverse(l2);
        l1.next = r1;
        l2.next = r2;
        return h.next;
    }

    void reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
    }
}

