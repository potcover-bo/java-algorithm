package cc.potcover.lined_list;

import cc.potcover.ListNode;

import java.util.ArrayList;

/**
 * JZ6 从尾到头打印链表
 */
public class PrintListFromTailToHead {
    ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
       recur(listNode);

        return list;
    }

    public void recur(ListNode listNode) {
        if (listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }

    }
}
