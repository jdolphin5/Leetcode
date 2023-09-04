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
        Set<ListNode> mySet = new HashSet<>();

        while (head != null) {
            if (mySet.contains(head)) {
                return true;
            }
            else {
                mySet.add(head);
                head = head.next;
            }
        }

        return false;
    }
}