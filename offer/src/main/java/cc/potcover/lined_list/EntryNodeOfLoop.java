package cc.potcover.lined_list;

import cc.potcover.ListNode;

/**
 * JZ23 链表中环的入口结点
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode slow = pHead, fast = pHead;

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

        fast = pHead;

        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;

    }
}
