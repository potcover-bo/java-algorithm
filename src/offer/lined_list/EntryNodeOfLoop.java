package cc.potcover.lined_list;

import offer.ListNode;

/**
 * JZ23 链表中环的入口结点
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }

        }

        if (fast == null || fast.next == null) {
            return null;
        }

        fast = head;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}
