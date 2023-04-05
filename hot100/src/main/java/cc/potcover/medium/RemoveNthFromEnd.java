package cc.potcover.medium;

import linked_list.problem.ListNode;

public class RemoveNthFromEnd {
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;

        ListNode dummy = new ListNode(-1, head);
        ListNode cur = dummy;
        while (head != null) {
            length++;
            head = head.next;
        }

        length -= n;
        while (length-- > 0) {
            cur = cur.next;
        }
        cur.next = cur.next.next;


        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);
        //head.next.next = new ListNode(3);
        //head.next.next.next = new ListNode(4);
        //head.next.next.next.next = new ListNode(5);

        ListNode cur = removeNthFromEnd(head, 1);

        while (cur != null) {
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
}
