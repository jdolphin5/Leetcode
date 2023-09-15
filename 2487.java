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
    private ListNode reverseNodes(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode headCopy = head;
        ListNode reversedList = reverseNodes(headCopy);
        ListNode dummyRet = new ListNode();
        ListNode ret = dummyRet;
        int curMax = 0;

        while (reversedList != null) {
            if (reversedList.val >= curMax) {
                ret.next = new ListNode(reversedList.val);
                ret = ret.next;
            }
            curMax = Math.max(curMax, reversedList.val);
            reversedList = reversedList.next;
        }

        return reverseNodes(dummyRet.next);
    }
}