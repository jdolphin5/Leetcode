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
    private int gcd (int a, int b) {
        if (a % b == 0)
            return b;
        
        return gcd(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode newList = dummyHead.next;

        while (head.next != null) {
            ListNode next = head.next;
            ListNode mid = new ListNode(gcd(head.val, head.next.val));
            mid.next = next;
            head.next = mid;
            
            head = next;
        }

        return dummyHead.next;
    }
}