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

    private ListNode reverse(ListNode node)
    {
        ListNode prev = null;
        ListNode current = node;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode resHead = new ListNode(0);
        ListNode res = resHead;

        int car = 0;

        while(cur1 != null || cur2 != null || car == 1) {
            int count = car;
            car = 0;
            if (cur1 != null) {
                count += cur1.val;
                cur1 = cur1.next;
            }
            if (cur2 != null) {
                count += cur2.val;
                cur2 = cur2.next;
            }
            if (count >= 10) {
                car = 1;
                count -= 10;
            }
            res.next = new ListNode(count);
            res = res.next;
        }

        res = reverse(resHead.next);

        return res;


    }
}