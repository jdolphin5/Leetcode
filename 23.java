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
    public ListNode mergeKLists(ListNode[] lists) {

        ListNode dummyHead = new ListNode(0);
        ListNode res = dummyHead;
        int numLists = lists.length;
        int k = 0;

        while (k < numLists) {
            k = 0;
            int smallest = Integer.MAX_VALUE;
            int smallestIndex = -1;
            for (int i = 0; i < numLists; i++) {
                if (lists[i] == null) {
                    k++;
                    continue;
                }
                if (lists[i].val < smallest) {
                    smallest = lists[i].val;
                    smallestIndex = i;
                }
            }
            if (smallestIndex != -1) {
                res.next = new ListNode(smallest);
                res = res.next;
                lists[smallestIndex] = lists[smallestIndex].next;
            }
        }

        return dummyHead.next;

    }
}