public class No141 {
    public static void main(String[] args) {
        
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        ListNode p = head, q = head;
        while (p != null && p.next != null) {
            p = p.next.next;
            q = q.next;
            if (p == q)
                return true;
        }
        return false;
    }
}