/**
 * Author daydream
 * Description
 * Date 2024/10/17 21:19
 */
public class No707 {
    public static void main(String[] args) {
        MyLinkedList myLinkedList = new MyLinkedList();
        myLinkedList.addAtHead(7);
        myLinkedList.addAtHead(2);
        myLinkedList.addAtHead(1);
        myLinkedList.addAtIndex(3, 0);
        myLinkedList.deleteAtIndex(2);
        myLinkedList.addAtHead(6);
        myLinkedList.addAtTail(4);
        int i = myLinkedList.get(4);
        System.out.println(i);
    }
}

class MyLinkedList {
    Node head;

    public MyLinkedList() {
        head = new Node(0);
    }

    public int get(int index) {
        Node p = head;
        int res = 0;
        for (int i = 0; i <= index; i++) {
            p = p.next;
            if (p == null)
                return -1;
            res = p.val;
        }
        return res;
    }

    public void addAtHead(int val) {
        Node myLinkedList = new Node(val);
        myLinkedList.next = head.next;
        head.next = myLinkedList;
    }

    public void addAtTail(int val) {
        Node p = head;
        while (p.next != null) {
            p = p.next;
        }
        Node myLinkedList = new Node(val);
        p.next = myLinkedList;
    }

    public void addAtIndex(int index, int val) {
        Node p = head;
        Node myLinkedList = new Node(val);
        for (int i = 0; i <= index - 1; i++) {
            p = p.next;
            if (p == null) {
                break;
            }
        }
        if (p != null) {
            myLinkedList.next = p.next;
            p.next = myLinkedList;
        }
    }

    public void deleteAtIndex(int index) {
        Node p = head;
        for (int i = 0; i <= index - 1; i++) {
            p = p.next;
            if (p == null)
                break;
        }
        if (p != null && p.next != null) {
            p.next = p.next.next;
        }
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}