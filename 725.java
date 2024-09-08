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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int len = 0;

        ListNode headCopy = head;

        while (headCopy != null) {
            len++;
            headCopy = headCopy.next;
        }

        int subLen = len / k;
        int modRem = len % k;

        ListNode[] ret = new ListNode[k];
        int i = 0;
        int j = 0;
        ListNode newNode = null;

        while (head != null) {
            if (j < subLen || (j == subLen && modRem > 0)) {
                if (newNode == null) {
                    newNode = new ListNode(head.val);
                    ret[i] = newNode;
                }
                else if (j < subLen) {
                    newNode.next = new ListNode(head.val);
                    newNode = newNode.next;
                }
                else if (j == subLen) {
                    newNode.next = new ListNode(head.val);
                    newNode = newNode.next;
                    modRem--;
                }

                j++;
                head = head.next;
            }
            else {
                i++;
                j = 0;
                newNode = null;
            }
        }

        return ret;
    }
}