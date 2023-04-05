package cc.potcover.lined_list;

import cc.potcover.ListNode;

/**
 * JZ76 删除链表中重复的结点
 */
public class DeleteDuplication {
    public static ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode pre = dummy;
        while (pHead != null && pHead.next != null) {

            if (pre.next.val != pHead.next.val) {
                pre = pHead;
                pHead = pHead.next;
            }else {
                while (pHead.next != null && pre.next.val == pHead.next.val){
                    pHead = pHead.next;
                }
                pre.next = pHead.next;
                pHead = pHead.next;
            }

        }

        return dummy.next;
    }

}
