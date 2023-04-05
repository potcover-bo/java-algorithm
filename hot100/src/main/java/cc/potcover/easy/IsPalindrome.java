package cc.potcover.easy;

import linked_list.problem.ListNode;

public class IsPalindrome {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return false;
    }
}
