/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode hashStart = head;
        HashMap cycle = new HashMap<Integer, ListNode>();
        int i = 0;
        while (hashStart != null && hashStart.next != null) {
            cycle.put(i, hashStart);
            i++;
            hashStart = hashStart.next;
            //if value in hash equals hashStart.next, return true;
            if (cycle.containsValue(hashStart)) {
                return true;
            }
        }
        return false;
    }
}