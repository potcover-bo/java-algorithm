package cc.potcover.lined_list;

import cc.potcover.ListNode;

/**
 * JZ52 两个链表的第一个公共结点
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int m = 0;
        int n = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (pHead1 != null) {
            m++;
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            n++;
            pHead2 = pHead2.next;
        }

        if (m >= n) {
            int sub = m - n;
            while (sub-- > 0) {
                p1 = p1.next;
            }
        }else {
            int sub = n - m;
            while (sub-- > 0) {
                p2 = p2.next;
            }
        }
        while (p1 != p2 && p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p1;
    }
}
