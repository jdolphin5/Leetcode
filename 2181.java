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
    public ListNode mergeNodes(ListNode head) {
        ListNode cur = head;
        ListNode dummyHead = new ListNode(0);
        ListNode newNode = dummyHead;
        boolean first = true;
        while (cur != null) {
            if (cur.val == 0) {
                first = true;
            }
            else {
                if (first) {
                    newNode.next = new ListNode(cur.val);
                    newNode = newNode.next;
                    first = false;
                }
                else {
                    newNode.val += cur.val;
                }
            }
            cur = cur.next;
        }
        return dummyHead.next;
    }
}