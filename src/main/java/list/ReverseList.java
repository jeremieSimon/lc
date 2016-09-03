package list;

/**
 * Reverse a singly linked list.
 * https://leetcode.com/problems/reverse-linked-list/
 */
public class ReverseList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        @Override
        public String toString() {
            return "val: " + val;
        }
    }

    public static ListNode reverseList(ListNode head) {
        // base case
        if (head == null || head.next == null) {
            return head;
        }

        if (head.next.next == null) {
            ListNode newHead = head.next;
            head.next.next = head;
            head.next = null;
            return newHead;
        }

        ListNode before = head;
        ListNode curr = head.next;
        ListNode next = head.next.next;
        while (next != null) {
            ListNode tmp = next.next;
            next.next = curr;
            curr.next = before;
            before = curr;
            curr = next;
            next = tmp;
        }
        head.next = null;
        return curr;
    }
}
