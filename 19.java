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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        int nodeCount = 0;
        ListNode node = head;
        while(node != null) {
            node = node.next;
            nodeCount++;
        }

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        node = dummyHead;

        int nFromStart = nodeCount-n;
        nodeCount = 0;

        while(node != null) {
            System.out.println("nodeCount: " + nodeCount + " nFromStart: " + nFromStart);
            if (node.next != null && nodeCount == nFromStart) {
                node.next = node.next.next;
            }
            else {
                node = node.next;
            }
            nodeCount++;
        }


        return dummyHead.next;
    }
}