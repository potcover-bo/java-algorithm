package cc.potcover.lined_list;

import cc.potcover.ListNode;

/**
 * JZ18 删除链表的节点
 */
public class DeleteNode {
    public ListNode deleteNode (ListNode head, int val) {

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        dummy.next = head;

        while (head != null){
            if (head.val == val) {
                pre.next = head.next;
                break;
            }
            pre = head;
            head = head.next;
        }

        return dummy.next != null ? dummy.next : pre.next;
    }
}
