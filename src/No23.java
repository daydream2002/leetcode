import java.util.*;

/**
 * Author daydream
 * Description
 * Date 2024/10/8 10:05
 */
public class No23 {
    public static void main(String[] args) {
        ListNode listNode1 = ListNode.init(new int[]{1, 4, 5});
        ListNode listNode2 = ListNode.init(new int[]{1, 3, 4});
        ListNode listNode3 = ListNode.init(new int[]{2, 6});
        ListNode[] listNodes = new ListNode[3];
        listNodes[0] = listNode1;
        listNodes[1] = listNode2;
        listNodes[2] = listNode3;
        ListNode listNode = new Solution23Three().mergeKLists(listNodes);
        ListNode.print(listNode);
    }
}

//两两合并
class Solution23One {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0)
            return null;
        ArrayList<ListNode> list = new ArrayList<>(Arrays.asList(lists));
        while (list.size() > 1) {
            ListNode list1 = list.removeFirst();
            ListNode list2 = list.removeFirst();
            ListNode listNode = mergeKTwo(list1, list2);
            list.add(listNode);
        }
        return list.getFirst();
    }

    public ListNode mergeKTwo(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}

//分治合并
class Solution23Two {
    public ListNode mergeKLists(ListNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[r];
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        return mergeKTwo(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public ListNode mergeKTwo(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode cur = head;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        if (list1 != null) {
            cur.next = list1;
        }
        if (list2 != null) {
            cur.next = list2;
        }
        return head.next;
    }
}
//优先队列
class Solution23Three {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p;
        p = head;
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
        for (ListNode list : lists) {
            if (list != null)
                queue.offer(list);
        }
        while (!queue.isEmpty()) {
            ListNode poll = queue.poll();
            if (poll.next != null)
                queue.offer(poll.next);
            p.next = poll;
            p = p.next;
        }
        return head.next;
    }
}
