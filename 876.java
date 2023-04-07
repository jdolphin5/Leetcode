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
    public ListNode middleNode(ListNode head) {
        ListNode result = head;
        int size = 0;
        for(ListNode n = head; n.next != null; n = n.next) {
            size++;
        }
         
        int middleNum = 0;
        if (size % 2 == 0) {
            middleNum = size / 2;
        }
        else {
            middleNum = (size + 1) / 2;
        }
        for (int i = 0; i < middleNum; i++) {
            result = result.next;
        }
        return result;
    }
}
