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
    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> myList = new ArrayList<>();
        ListNode cur = head;
        if (cur == null) return head;
        if (cur.next == null) return head;

        while (cur != null) {
            myList.add(cur.val);
            while (cur.next != null && myList.contains(cur.next.val)) {
                cur.next = cur.next.next;
            }
            cur = cur.next;
        }

        return head;
    }
}