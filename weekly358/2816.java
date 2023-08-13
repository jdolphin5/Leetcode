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
    
    private ListNode reverse(ListNode node) {
        ListNode prev = null;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
    
    public ListNode doubleIt(ListNode head) {
        ListNode dummyHead  = new ListNode(0);
        ListNode res = dummyHead;
        ListNode node = head;
        ListNode prev = null;
        
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        
        node = prev;
        
        
        
        int carry = 0;
        while (node != null || carry == 1) {
            int a = 0;
            if (node != null) {
                a = node.val;
            }
            int sum = a + a + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            if (node != null)
                node = node.next;
        }
        return reverse(dummyHead.next);
        
        
        
    }
}
        


        