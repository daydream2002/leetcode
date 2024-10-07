/**
 * @author wjh
 * @date 2024/9/30 20:30
 */
public class ListNode {
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

    static ListNode init(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]), cur;
        cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
        return head;
    }

    static void print(ListNode head) {
        while (head != null) {
            if (head.next != null)
                System.out.print(head.val + "->");
            else
                System.out.println(head.val);
            head = head.next;
        }
    }
}