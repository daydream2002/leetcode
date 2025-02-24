import java.util.ArrayList;

/**
 * Author daydream
 * Description
 * Date 2025/2/16 13:32
 */
public class No234 {
    public static void main(String[] args) {
        ListNode head = ListNode.init(new int[]{1, 2, 0, 2, 1});
        boolean palindrome = new Solution234Two().isPalindrome(head);
    }
}

class Solution234One {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        for (int i = 0; i < (list.size() + 1) / 2; i++) {
            if (list.get(i) != list.get(list.size() - 1 - i))
                return false;
        }
        return true;
    }
}

class Solution234Two {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head, pre = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        pre.next = null;
        slow = reverse(slow);
        while (head != null) {
            if (head.val != slow.val)
                return false;
            head = head.next;
            slow = slow.next;
        }
        return true;
    }

    ListNode reverse(ListNode head) {
        ListNode pre = null, temp = null;
        while (head != null) {
            temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}