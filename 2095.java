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
    public ListNode deleteMiddle(ListNode head) {
        ListNode ret = new ListNode(0);
        ListNode dummyHead = ret;
        ListNode newHead = head;
        int len = 0;

        while (newHead != null) {
            len++;
            newHead = newHead.next;
        }

        int mid = len / 2;
        int i = 0;

        while (head != null) {
            if (i != mid) {
                dummyHead.next = new ListNode(head.val);
                dummyHead = dummyHead.next;
            }
            
            i++;
            head = head.next;
        }

        return ret.next;
    }
}