/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    private static ListNode sortedMerge(ListNode a, ListNode b)
    {
        ListNode result = null;
 
        // Base cases
        if (a == null)
            return b;
        if (b == null)
            return a;
 
        if (a.val < b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        }
        else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
 
        return result;
    }

    private static ListNode getMiddle(ListNode head)
    {
        if (head == null)
            return head;
 
        ListNode slow = head, fast = head;
 
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
 
        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
 
        // get the middle of the list
        ListNode mid = getMiddle(head);
        ListNode nextOfMiddle = mid.next;
 
        // set the next of middle node to null to separate left from right
        mid.next = null;

        ListNode left = sortList(head);
 
        ListNode right = sortList(nextOfMiddle);
 
        ListNode sortedList = sortedMerge(left, right);
 
        return sortedList;
    }
}