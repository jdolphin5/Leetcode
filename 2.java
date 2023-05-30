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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        ListNode dummyHead = new ListNode(0);
        ListNode res = dummyHead;

        int carry = 0;
        while (l1 != null || l2 != null || carry == 1) {
            int a = 0;
            int b = 0;
            if (l1 != null) {
                a = l1.val;
            }
            if (l2 != null) {
                b = l2.val;
            }
            int sum = a + b + carry;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            else {
                carry = 0;
            }
            res.next = new ListNode(sum);
            res = res.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        return dummyHead.next;
    }
}