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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode start = head;
        ListNode curPos = head;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            curPos = curPos.next;
            cur = cur.next.next;
            if (curPos == cur) {
                break;
            //    return curPos;
            }
        }
        if (cur == null || cur.next == null) {
            return null;
        }

        while (cur != start) {
            start = start.next;
            cur = cur.next;
        }
        return start;
    }
}