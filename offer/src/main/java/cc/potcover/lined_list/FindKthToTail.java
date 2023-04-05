package cc.potcover.lined_list;

import cc.potcover.ListNode;

/**
 * JZ22 链表中倒数最后k个结点
 */
public class FindKthToTail {
    public ListNode FindKthToTail (ListNode pHead, int k) {
        int len = 0;

        ListNode head = pHead;

        while (pHead != null) {
            len++;
            pHead = pHead.next;
        }

        if (k > len) {
            return null;
        }
        int sub = len - k;
        while (head != null && sub-- > 0) {
            head = head.next;
        }

        return head;
    }
}
