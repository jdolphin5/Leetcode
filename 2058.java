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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int cur = -1;
        boolean first = false;
        int last = -1;
        int lastPrev = -1;

        while (head != null) {
            if (last != -1 && lastPrev != -1) {
                if ((last > lastPrev && last > head.val) || (last < lastPrev && last < head.val)) {
                    if (first) {
                        min = Math.min(min, cur);
                        max = Math.max(max + cur, cur);
                    }
                    first = true;
                    cur = 0;
                }
            }

            lastPrev = last;
            last = head.val;
            if (cur >= 0) cur++;

            head = head.next;
        }

        min = min == Integer.MAX_VALUE ? -1 : min;
        max = max == Integer.MIN_VALUE ? -1 : max;

        return new int[] { min, max };
    }
}