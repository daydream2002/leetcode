import java.util.*;


public class Test {
    public static void main(String[] args) {

    }
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode curA = headA, curB = headB;

        while (curA != null) {
            curA = curA.next;
            lenA++;
        }
        while (curB != null) {
            curB = curB.next;
            lenB++;
        }
        if (lenA > lenB) {
            curA = headA;
            curB = headB;
            for (int i = 0; i < lenA - lenB; i++) {
                curA = curA.next;
            }
            if (headA == headB)
                return headA;
            for (int i = 0; i < lenB; i++) {
                curA = curA.next;
                curB = curB.next;
                if (curA == curB) {
                    return curA;
                }
            }
            return null;
        } else {
            curA = headA;
            curB = headB;
            for (int i = 0; i < lenB - lenA; i++) {
                curB = curB.next;
            }
            if (headA == headB)
                return headA;
            for (int i = 0; i < lenA; i++) {
                curA = curA.next;
                curB = curB.next;
                if (curA == curB) {
                    return curA;
                }
            }
            return null;
        }
    }
}