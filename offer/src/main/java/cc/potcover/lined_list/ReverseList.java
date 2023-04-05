package cc.potcover.lined_list;

import cc.potcover.ListNode;

/**
 * JZ24 反转链表
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur.next != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }


}
