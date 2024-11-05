import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Author daydream
 * Description
 * Date 2024/10/15 20:40
 */
public class Test {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode p = head, q = head;
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next.next;
            if (p == q) {
                p = head;
                while (p != q) {
                    p = p.next;
                    q = q.next;
                }
                return p;
            }
        }
        return null;
    }
}