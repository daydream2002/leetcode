import java.util.HashSet;

/**
 * Author daydream
 * Description
 * Date 2024/10/22 20:05
 */
public class Mianshi0207 {
    public static void main(String[] args) {

    }
}

//哈希表
class Solution0207One {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB))
                return headB;
            headB = headB.next;
        }
        return null;
    }
}

//双指针
class Solution0207Two {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)
            return null;
        ListNode p = headA, q = headB;
        while (true) {
            if (p == q)
                return p;
            if (p == null)
                p = headB;
            else
                p = p.next;
            if (q == null)
                q = headA;
            else
                q = q.next;
        }
    }
}