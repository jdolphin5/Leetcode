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
    public void reorderList(ListNode head) {
        ListNode node = head;
        ListNode node2 = head;
        ListNode node3 = head;
        ListNode node4 = head;

        int len = 0;
        int curLen = 0;

        while (node2 != null && node2.next != null) {
            node = node.next;
            node2 = node2.next.next;
            len++;
        }

        Stack<ListNode> myStack = new Stack<>();

        while (node != null) {
            myStack.push(node);
            node = node.next;
            len++;
        }

        //System.out.println(myStack.size());

        while (curLen < len/2 && node4 != null && node4.next != null) {
            curLen++;
            //System.out.println(node3.val);

            ListNode next = node3.next;
            node3.next = myStack.pop();
            node3 = node3.next;
            //System.out.println(node3.val);

            node3.next = next;
            node3 = node3.next;

            node4 = node4.next.next;
        }

        node3.next = null;
    }
}